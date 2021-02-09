package ru.netology

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.ImageView
import ru.netology.databinding.ActivityMainBinding
import ru.netology.utils.Calculator.calculator

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)

        val  post = Post(
                id = 1,
                author = "Нетологияю Университет интернет - профессий будущего",
                content = getString(R.string.sample_text),
                published = "06 февраля в 20:30",
                liked = false,
                likes = 10,
                toSend = false,
                toSends = 21099997,
                viewing = false,
                viewings = 9997
        )

        with(binding){
            content.text = post.content

            imageLike.setOnClickListener {
                post.liked = !post.liked
                imageLike.setImageResource(getImageResource(post))

                if (post.liked) post.likes++ else post.likes--
                like.text = post.likes.toString()
            }

            imageToSend.setOnClickListener {
                post.toSends++
                toSend.text  = calculator(post.toSends)
            }

            imageViewing.setOnClickListener {
                post.viewings++
                viewing.text = calculator(post.viewings)
            }
        }
    }

    private fun getImageResource(post: Post) =
        if (post.liked) R.drawable.ic_liked_24 else R.drawable.ic_baseline_favorite_border_24

}
