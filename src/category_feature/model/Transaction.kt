package category_feature.model

data class Transaction(
    val type: String,
    val categoryName: String,
    val timestamp: String,
    val status: String
)