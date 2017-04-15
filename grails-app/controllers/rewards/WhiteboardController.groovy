package rewards

class WhiteboardController {

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
}
