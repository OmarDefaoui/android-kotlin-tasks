fun main(){
    print("The first object: \n")
    val iphone11Pro = Mobile()
    iphone11Pro.brand = "Apple"
    iphone11Pro.model = "Iphone 11 Pro"
    iphone11Pro.mrp = 999.99
    iphone11Pro.discount = 25.99
    iphone11Pro.printDetails()
    print("-> The actual price is: ${iphone11Pro.getActualPrice()}")

    print("\n\nThe second object: \n")
    val galaxyS20 = Mobile()
    galaxyS20.brand = "Samsung"
    galaxyS20.model = "Galaxy S20"
    galaxyS20.mrp = 800.00
    galaxyS20.discount = 35.99
    galaxyS20.printDetails()
    print("-> The actual price is: ${galaxyS20.getActualPrice()}")

    print("\n\nThe third object: \n")
    val onePlus7 = Mobile()
    onePlus7.brand = "Apple"
    onePlus7.model = "One Plus 7"
    onePlus7.mrp = 549.99
    onePlus7.discount = 49.99
    onePlus7.printDetails()
    print("-> The actual price is: ${onePlus7.getActualPrice()}")
}