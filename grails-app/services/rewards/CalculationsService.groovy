package rewards

import grails.transaction.Transactional

@Transactional
class CalculationsService {

    def welcome(params) {
        def firstName = params.first
        def totalPoints = params.points.toInteger()
        def welcome = ""

        if (totalPoints >= 5) {
            welcome = "Welcome back $firstName, this drink is on us."
        } else if (totalPoints == 4) {
            welcome = "Welcome back $firstName, your next drink is free."
        } else {
            welcome = "Welcome back $firstName, you have $totalPoints points."
        }

        return welcome
    }

    def getTotalPoints(customerInstance) {
        def totalAwards = 0
        // look at the domain for Customer and use the defined nickname awards
        customerInstance.awards.each{
            totalAwards = totalAwards + it.points
        }
        customerInstance.totalPoints = totalAwards
        return customerInstance
    }

    def processCheckin(lookupInstance) {
        // Lookup customer by phone number
        def customerInstance = Customer.findByPhone(lookupInstance.phone)
        
        // Set up a new customer
        if (!customerInstance) {
            customerInstance = lookupInstance
            // needs a first name
            customerInstance.firstName = "Customer"
        }

        // Calculate the total points
        def totalAwards = 0
        // look at the domain for Customer and use the defined nickname awards
        customerInstance.awards.each{
            totalAwards = totalAwards + it.points
        }
        customerInstance.totalPoints = totalAwards

        // Create welcome message
        def welcomeMessage = ""
        def firstName = customerInstance.firstName

        if (totalAwards >= 5) {
            welcomeMessage = "Welcome back $firstName, this drink is on us."
        } else if (totalAwards == 4) {
            welcomeMessage = "Welcome back $firstName, your next drink is free."
        } else if (totalAwards < 4 && totalAwards > 0) {
            welcomeMessage = "Welcome back $firstName, you have ${totalAwards +1} points."
        } else {
            welcomeMessage = "Welcome $firstName, thank you for registering!"
        }

        // Add new award
        if (customerInstance.totalPoints < 5) {
            customerInstance.addToAwards(new Award(awardDate: new Date(), type: "Purchase", points: 1))
        } else {
            customerInstance.addToAwards(new Award(awardDate: new Date(), type: "Reward", points: -5))
        }

        // Save the instance
        customerInstance.save(flush: true)

        // Return the data to the view
        return [customerInstance, welcomeMessage]
    }
}
