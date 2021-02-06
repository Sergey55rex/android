package ru.netology

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import ru.netology.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)

        val  post = Post(
                getString(R.string.sample_text),
                liked = false
        )
        with(binding){
            content.text = post.content
            imageView2.setImageResource(getImageResource(post))

            imageView2.setOnClickListener {
                post.liked = !post.liked
                imageView2.setImageResource(getImageResource(post))
            }
        }
    }

    private fun getImageResource(post: Post) =
        if (post.liked) R.drawable.ic_liked_24 else R.drawable.ic_baseline_favorite_border_24
}
