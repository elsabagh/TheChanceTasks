package socialMedia

fun main() {
    val post: Post = Post(
        publisherName = "ahmed",
        content = "",
        mediaContent = MediaContent(
            hdVideoUrl = "ho ahmed",
            fullVideoUrl = ""
        )
    )
    println(post.publisherName)

    println(post.likeCount)
    post.publisherName = "ali"


    println(post.publisherName)
    println(post.mediaContent?.hdVideoUrl)
    post.like()
    post.like()

    println(post.likeCount)

    post.removeLike()

    println(post.likeCount)
}
