package foodOrder

fun main() {
    val cart = Cart()

    val mainDish = Meal(
        name = "fish", price = 15000
    )
    val salad = Meal(
        name = "salad",
        price = 100
    )

    cart.addMeal(mainDish)
    cart.addMeal(salad)

    val payment: Payment = PaymentImpl()
    val totalPrice = calculateTotalPrice(cart)
    val isPaymentSuccessful = payment.payment(totalPrice)

    if(isPaymentSuccessful) {
        println("Payment successful")
    }else{
        println("Payment failed")
    }

}

fun calculateTotalPrice(cart: Cart): Int {
    var totalPrice = 0
    cart.getAllItems().forEach { item ->
        totalPrice += item.price
    }
    return totalPrice
}


