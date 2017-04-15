package rewards

class WhiteboardController {
    def calculationsService

    def index() { }

    def variables() {
        // Integer
        // Add 1 to an integer increments the integer
        def myTotal = 1
        render("Total: " + myTotal)
        render("</br>" + myTotal.class)
        myTotal = myTotal + 1
        render("</br>New Total: " + myTotal + "</br>")

        // String
        // Add 1 to a string makes it "String1"
        def firstName = "Mike"
        render("</br>Name: " + firstName)
        render("</br>" + firstName.class)

        // Date
        // Add 1 to a date incremenets the date by one day
        def today = new Date("2/1/2014")
        render("</br>Today is: " + today)
        render("</br>" + today.class)
    }

    def strings() {
        def first = "Mike"
        def last = "Kelly"
        def fullName = "Mike Kelly"
        def input = "SHOUTING"
        def state = "ut"
        def points = 4
        // Groovy Strings
        render("Hey there $first. You already have $points points!</br>")
        render("Today is ${new Date()}</br>")
        render("Your string, $fullName, has ${fullName.length()} length.</br>")
        render("Please stop ${input.toLowerCase()}!</br>")
        render("You live in ${state.toUpperCase()}.</br>")
    }

    // params is http://localhost:8080/rewards/whiteboard/conditions/?first=Ivan&points=4
    def conditions1() {
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

        render welcome
    }

    // Same as conditions but with a switch
    def conditions2() {
        def firstName = "Mike"
        def totalPoints = 4
        def welcome = ""

        switch (totalPoints) {
            case 5:
                welcome = "Welcome back $firstName, this drink is on us."
                break
            case 4:
                welcome = "Welcome back $firstName, your next drink is free."
                break
            case 2..3:
                welcome = "Something something something."
                break
            default:
                welcome = "Welcome back $firstName, you have $totalPoints points."
        }

        render welcome
    }

    // Using a service called Calculations
    def conditions() {
        def welcomeMessage = calculationsService.welcome(params)
        render welcomeMessage
    }
}
