package foodOrder

class PaymentImpl : Payment {
    override fun payment(price: Int): Boolean {
        println("Payment success: $price")
        return true
    }
}