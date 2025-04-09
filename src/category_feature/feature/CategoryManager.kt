package category_feature.feature

import category_feature.model.CategoryList
import category_feature.model.Transaction
import java.util.*

class CategoryManager(initialCategories: List<String>) : CategoryOperations {
    private val categoryList = CategoryList(initialCategories.map { it.lowercase(Locale.getDefault()) }.toMutableList())
    private val transactions = mutableListOf<Transaction>()  // List to store transactions

    // Add Category
    override fun addCategory(name: String): Boolean {
        return if (categoryList.categories.contains(name)) {
            false
        } else {
            categoryList.categories.add(name)
            // Add transaction for this action
            transactions.add(Transaction("Add", name, Date().toString(), "Success"))
            true
        }
    }

    // Update Category
    override fun updateCategory(oldName: String, newName: String): Boolean {
        val index = categoryList.categories.indexOf(oldName)
        return if (index != -1) {
            categoryList.categories[index] = newName
            // Add transaction for this action
            transactions.add(Transaction("Update", oldName, Date().toString(), "Success"))
            true
        } else {
            // Add transaction for failed update
            transactions.add(Transaction("Update", oldName, Date().toString(), "Failed"))
            false
        }
    }

    // Delete Category
    override fun deleteCategory(name: String): Boolean {
        return if (categoryList.categories.remove(name)) {
            // Add transaction for this action
            transactions.add(Transaction("Delete", name, Date().toString(), "Success"))
            true
        } else {
            // Add transaction for failed delete
            transactions.add(Transaction("Delete", name, Date().toString(), "Failed"))
            false
        }
    }

    // Check if Category exists
    override fun checkExists(name: String): Boolean {
        return categoryList.categories.contains(name)
    }

    // Display Categories
    override fun displayCategories(): String {
        val stringBuilder = StringBuilder()
        categoryList.categories.forEachIndexed { index, category ->
            stringBuilder.append("[${index + 1}] $category\n")
        }
        return stringBuilder.toString()
    }

    // Display Transactions (formatted as a table)
    override fun displayTransactions(): String {
        val stringBuilder = StringBuilder()
        stringBuilder.append("=== Transaction History ===\n")
        stringBuilder.append("Type       | Category Name  | Timestamp                | Status\n")
        stringBuilder.append("------------------------------------------------------------\n")
        transactions.forEach { transaction ->
            stringBuilder.append("${transaction.type.padEnd(10)}| ${transaction.categoryName.padEnd(15)}| ${transaction.timestamp.padEnd(25)}| ${transaction.status}\n")
        }
        return stringBuilder.toString()
    }
}