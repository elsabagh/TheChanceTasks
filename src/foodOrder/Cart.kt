package foodOrder

class Cart{
    private val mealsInCart: MutableList<Meal> = mutableListOf()

    fun addMeal(meal: Meal){
        mealsInCart.add(meal)
    }

    fun clearAllItems(){
        mealsInCart.clear()
    }

    fun getAllItems():List<Meal>{
        return mealsInCart
    }
}