package rewards

class InventoryController {

    // Index is considered the '/' page
    def index() { 
        render "Here is a list of everything."
    }

    def edit() {
        def productName = "Breakfast Blend"
        def sku = "BB01"
        // This is a mapping - key/value pair sent to the view
        [product:productName, sku:sku]
    }

    // '/remove' page
    def remove() {
        render "You have selected remove."
    }

    def list() {
        def allProducts = Product.list()
        [allProducts:allProducts]
    }
}
