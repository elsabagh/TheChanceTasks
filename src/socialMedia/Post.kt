package socialMedia

import org.w3c.dom.Comment

open class Post(
    var publisherName: String,
    val content: String,
    private val allowComments: Boolean = true,
    val mediaContent: MediaContent? = null
) {
    var likeCount: Int = 0
        private set

    var comments: MutableSet<Comment> = mutableSetOf()
        private set

    fun like() = likeCount++

    fun removeLike() = likeCount--

    fun addComment(comment: Comment) {
        if (allowComments) {
            comments.add(comment)
        }
    }
}