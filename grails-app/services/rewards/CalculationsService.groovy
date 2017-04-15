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
}
