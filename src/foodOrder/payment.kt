package foodOrder

interface Payment {
    fun payment(price: Int): Boolean
}