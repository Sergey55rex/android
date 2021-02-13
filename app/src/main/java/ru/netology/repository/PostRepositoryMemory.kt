package ru.netology.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import ru.netology.dto.Post

class PostRepositoriMemory: PostRepository {
    private var post = Post(
            id = 1,
            author = "Нетологияю Университет интернет - профессий будущего",
            content = "Привет, это новая Нетология! Когда-то Нетология начиналась с интенсивов по онлайн-маркетингу. Затем появились курсы по дизайну, разработке, аналитике и управлению. Мы растём сами и помогаем расти студентам: от новичков до уверенных профессионалов. Но самое важное остаётся с нами: мы верим, что в каждом уже есть сила, которая заставляет хотеть больше, целиться выше, бежать быстрее. Наша миссия — помочь встать на путь роста и начать цепочку перемен → http://netolo.gy/fyb",
            published = "06 февраля в 20:30",
            liked = false,
            likes = 10,
            toSend = false,
            toSends = 21099997,
            viewing = false,
            viewings = 9997
    )
    private val data = MutableLiveData(post)
    override fun get(): LiveData<Post> = data

    override fun like() {
        val currentPost = requireNotNull(data.value)
        val newPost = currentPost.copy(
                liked = !currentPost.liked,
                likes = if (currentPost.liked) {
                    currentPost.likes -1} else{
                    currentPost.likes +1
                }
        )

        data.value = newPost
    }

    override fun toSends(){
        val currentPost = requireNotNull(data.value)
        val newPost = currentPost.copy(
                toSends = if (currentPost.toSend) {
                    currentPost.toSends +1} else{
                    currentPost.toSends +1
                }
        )
        data.value = newPost
    }

    override fun viewing(){
        val currentPost = requireNotNull(data.value)
        val newPost = currentPost.copy(
                viewings = if (currentPost.viewing) {
                    currentPost.viewings +1} else{
                    currentPost.viewings +1
                }
        )
        data.value = newPost
    }
}
