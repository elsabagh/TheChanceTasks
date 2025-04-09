import category_feature.feature.CategoryManager
import java.util.*

fun main() {
    val categoryManager = CategoryManager(listOf("food", "transport", "entertainment"))

    // Display the menu of operations using Enum class
    while (true) {
        println("\n=== Category Operations ===")
        Operation.entries.forEachIndexed { index, operation ->
            println("${index + 1}. ${operation.description}")
        }
        print("Please select an operation (1-${Operation.entries.size}): ")

        when (readlnOrNull()?.toIntOrNull()) {
            1 -> {
                // Add Category
                print("Enter category name to add: ")
                val categoryName = readlnOrNull()?.trim()?.lowercase(Locale.getDefault())
                if (!categoryName.isNullOrEmpty()) {
                    val result = categoryManager.addCategory(categoryName)
                    println(if (result) "Category '$categoryName' added successfully." else "Category '$categoryName' already exists.")
                } else {
                    println("Invalid category name.")
                }
            }

            2 -> {
                // Update Category
                print("Enter old category name: ")
                val oldName = readlnOrNull()?.trim()?.lowercase(Locale.getDefault())
                print("Enter new category name: ")
                val newName = readlnOrNull()?.trim()?.lowercase(Locale.getDefault())

                if (!oldName.isNullOrEmpty() && !newName.isNullOrEmpty()) {
                    if (categoryManager.checkExists(oldName) && !categoryManager.checkExists(newName)) {
                        val result = categoryManager.updateCategory(oldName, newName)
                        println(if (result) "Category '$oldName' updated to '$newName'." else "Category '$oldName' does not exist.")
                    } else if (!categoryManager.checkExists(oldName)) {
                        println("Error: Category '$oldName' does not exist.")
                    } else {
                        println("Error: Category '$newName' already exists.")
                    }
                } else {
                    println("Invalid input.")
                }
            }

            3 -> {
                // Delete Category
                print("Enter category name to delete: ")
                val categoryName = readlnOrNull()?.trim()?.lowercase(Locale.getDefault())
                if (!categoryName.isNullOrEmpty()) {
                    val result = categoryManager.deleteCategory(categoryName)
                    println(if (result) "Category '$categoryName' deleted successfully." else "Category '$categoryName' does not exist.")
                } else {
                    println("Invalid category name.")
                }
            }

            4 -> {
                // Check if Category exists
                print("Enter category name to check: ")
                val categoryName = readlnOrNull()?.trim()?.lowercase(Locale.getDefault())
                if (!categoryName.isNullOrEmpty()) {
                    val exists = categoryManager.checkExists(categoryName)
                    println(if (exists) "Category '$categoryName' exists" else "Category '$categoryName' does not exist.")
                } else {
                    println("Invalid category name.")
                }
            }

            5 -> {
                // Display Categories
                println("Categories:\n${categoryManager.displayCategories()}")
            }

            6 -> {
                // Exit the program
                println("Exiting program. Goodbye!")
                return
            }

            else -> println("Invalid choice. Please select a valid operation (1-${Operation.values().size}).")
        }
    }
}

enum class Operation(val description: String) {
    ADD_CATEGORY("Add Category"),
    UPDATE_CATEGORY("Update Category"),
    DELETE_CATEGORY("Delete Category"),
    CHECK_EXISTS("Check if Category exists"),
    DISPLAY_CATEGORIES("Display Categories"),
    EXIT("Exit");
}