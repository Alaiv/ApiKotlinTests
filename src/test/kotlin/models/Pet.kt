package models

data class Pet(
    val id: Int,
    val category: Category,
    val name: String,
    val photoUrls: List<String>,
    val tags: List<Tag>,
    val status: String
)
