package personal_Finance_Tracker

enum class Category {
    FOOD, RENT, SALARY, ENTERTAINMENT, TRANSPORT, OTHER
}

fun checkCategory(name: String, result: Any?, correctResult: Any?) {
    if (result == correctResult) {
        println("Pass - $name")
    } else {
        println("Fail - $name")
    }
}


fun addCategory(name: String): Category? {
    return null
}

fun main() {

    val category = addCategory("food")
    checkCategory("Test Category FOOD", category, Category.FOOD)

    val category2 = addCategory("rent")
    checkCategory("Test Category RENT", category2, Category.RENT)

    val category3 = addCategory("vacation")
    checkCategory("Test Category OTHER", category3, Category.OTHER)
}
