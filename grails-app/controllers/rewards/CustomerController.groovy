package rewards

class CustomerController {
    static scaffold = true

    def calculationsService

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

    def customerLookup(Customer lookupInstance) {
        // creates two variables that will be populated by our service
        def (customerInstance, welcomeMessage) = calculationsService.processCheckin(lookupInstance)

        // need to send this info to checkin.gsp but checkin() function is empty so use render
        render(view: "checkin", model: [customerInstance: customerInstance, welcomeMessage: welcomeMessage])
    }

    def checkin() {
        
    }

    // FOLLOWING OVERRIDES DYNAMIC SCAFFOLDING

    // This sets up the Grails page view the same way it would automatically
    // customerInstanceCount is needed for proper amount of pagination to do
    def index() {
        params.max = 10
        [customerInstanceList: Customer.list(params), customerInstanceCount: Customer.count()]
    }

    // Create the customer form
    def create() {
        // Create a new instance of customer and pass all of the information from the params in
        [customerInstance: new Customer()]
    }

    // Save the customer object from the form
    // save will need a show
    def save(Customer customerInstance) {
        customerInstance.save()
        // need to go into a "show" action after a save
        redirect(action: "show", id: customerInstance.id)
    }

    def show(Long id) {
        def customerInstance = Customer.get(id)

        // calculate the total points using the service
        customerInstance = calculationsService.getTotalPoints(customerInstance)

        [customerInstance: customerInstance]
    }

    // edit will need an update
    def edit(Long id) {
        // query the item out of the database
        def customerInstance = Customer.get(id)
        [customerInstance: customerInstance]
    }

    // Working with two versions of the data - old and the edited
    def update(Long id) {
        def customerInstance = Customer.get(id)
        customerInstance.properties = params
        // use flush: true so that it executes it right away and persists
        customerInstance.save(flush: true)
        redirect(action: "show", id: customerInstance.id)
    }

    def delete(Long id) {
        def customerInstance = Customer.get(id)
        customerInstance.delete(flush: true)
        redirect(action: "index")
    }

    // create a profile view for the user
    def profile() {
        def customerInstance = Customer.findByPhone(params.id)
        [customerInstance: customerInstance]
    }

    def updateProfile(Customer customerInstance) {
        customerInstance.save(flush: true)
        render(view: "profile", model: [customerInstance: customerInstance])
    }
}
