class Mobile {
    var brand: String = ""
    var model: String = ""
    var mrp: Double = 0.0
    var discount: Double = 0.0

    // return discounted price of mobile
    fun getActualPrice():Double{
        return mrp - discount
    }

    // print details of mobile
    fun printDetails(){
        print("\nMobile brand: $brand")
        print("\nMobile model: $model")
        print("\nMobile MRP: $mrp")
        print("\nMobile discount: $discount\n")
    }
}