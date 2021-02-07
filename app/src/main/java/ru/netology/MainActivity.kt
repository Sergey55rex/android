package ru.netology

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import ru.netology.databinding.ActivityMainBinding


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
                toSends = 5,
                viewing = false,
                viewings = 5
        )


        with(binding){
            content.text = post.content

            imageView2.setOnClickListener {
                post.liked = !post.liked
                imageView2.setImageResource(getImageResource(post))

                if (post.liked) post.likes++ else post.likes--
                like.text = post.likes.toString()
            }

            findViewById<ImageView>(R.id.imageView3).setOnClickListener{
                post.toSends++
                toSend.text = post.toSends.toString()
            }

            findViewById<ImageView>(ru.netology.R.id.imageView4).setOnClickListener{
                post.viewings++
                viewing.text = post.viewings.toString()
            }
        }
    }

    private fun Calkulator(post: Post) {
        if (post.liked) post.likes++ else post.likes--
        findViewById<TextView>(R.id.like)

    }


    private fun getImageResource(post: Post) =
        if (post.liked) R.drawable.ic_liked_24 else R.drawable.ic_baseline_favorite_border_24

}
