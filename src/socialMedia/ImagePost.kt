package socialMedia

class ImagePost(
    publisherName: String,
    content: String,
    allowComments: Boolean = true,
    val imageUrl: String = "",
) : Post(
    publisherName = publisherName,
    content = content,
    allowComments = allowComments,
) {
}