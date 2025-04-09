package category_feature.feature

import category_feature.model.CategoryList


class CategoryManager(initialCategories: List<String>) : CategoryOperations {
    private val categoryList = CategoryList(initialCategories.toMutableList())

    override fun addCategory(name: String): Boolean {
        return if (categoryList.categories.contains(name)) {
            false
        } else {
            categoryList.categories.add(name)
            true
        }
    }

    override fun updateCategory(oldName: String, newName: String): Boolean {
        val index = categoryList.categories.indexOf(oldName)
        return if (index != -1) {
            categoryList.categories[index] = newName
            true
        } else {
            false
        }
    }

    override fun deleteCategory(name: String): Boolean {
        return categoryList.categories.remove(name)
    }

    override fun checkExists(name: String): Boolean {
        return categoryList.categories.contains(name)
    }

    override fun displayCategories(): String {
        val stringBuilder = StringBuilder()
        categoryList.categories.forEachIndexed { index, category ->
            stringBuilder.append("[${index+1}] $category\n")
        }
        return stringBuilder.toString()
    }
}