package rewards

class CustomerController {
    static scaffold = true

    def lookup() {
        // querying a list of customers
        // def customerInstance = Customer.list(sort: "lastName", order: "desc", max: 5, offset: 5)
        
        // Dynamic Finder
        // def customerInstance = Customer.findAllByLastName("Foster")
        // def customerInstance = Customer.findAllByTotalPoints(5, [sort: "lastName"])
        // def customerInstance = Customer.findAllByPhone(params.id)
        // def customerInstance = Customer.findByPhone(params.id)

        // Case sensitive search
        // def customerInstance = Customer.findAllByLastNameLike("B%")
        
        // Case insensitive search
        // def customerInstance = Customer.findAllByLastNameIlike("b%")
        // def customerInstance = Customer.findAllByTotalPointsGreaterThan(3)
        // def customerInstance = Customer.findAllByTotalPointsGreaterThanEquals(3, [sort: "totalPoints", order: "desc"])
        // def customerInstance = Customer.findAllByTotalPointsBetween(2, 4)
        // def customerInstance = Customer.findAllByFirstNameAndTotalPoints("Bo", 3)
        def customerInstance = Customer.findAllByFirstNameIlikeAndTotalPointsGreaterThanEquals("B%", 3)
        
        [customerInstanceList:customerInstance]
    }

    //def index() { }

    def checkin() {
        
    }
}
