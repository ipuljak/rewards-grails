package rewards

class Customer {
    String firstName
    String lastName
    Long phone
    String email
    Integer totalPoints

    // Set awards = []
    // Set xorders = []

    static hasMany = [awards:Award, xorders:Xorder]

    static constraints = {
        phone()
        firstName(nullable: true)
        lastName(nullable: true)
        email(nullable: true, email: true)
        totalPoints(nullable: true, max: 10)
    }
}
