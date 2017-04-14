package rewards

class OrderItem {
    Integer qty
    Float total

    static belongsTo = [xorder:Xorder, product:Product]

    static constraints = {
    }
}
