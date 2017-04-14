package rewards

class Xorder {
    Date orderDate
	Integer orderNumber
	Float orderTotal

    //Set orderItems = []

    static belongsTo = [customer:Customer]
    static hasMany = [orderItems:OrderItem]

    static constraints = {
    }
}
