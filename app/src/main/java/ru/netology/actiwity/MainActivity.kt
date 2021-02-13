package ru.netology.actiwity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.activity.viewModels
import ru.netology.databinding.ActivityMainBinding
import ru.netology.utils.Calculator.calculator
import ru.netology.R
import ru.netology.viewmodel.PostViewModel

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)

        val viewModel: PostViewModel by viewModels()
        viewModel.data.observe(this@MainActivity, { post ->

            with(binding) {
                author.text = post.author
                published.text = post.published
                content.text = post.content

                if (post.liked) {
                    imageLike?.setImageResource(R.drawable.ic_liked_24)
                }else{
                    imageLike?.setImageResource(R.drawable.ic_baseline_favorite_border_24)
                }
                textLike.text = post.likes.toString()

                textToSend.text = calculator(post.toSends)

                textViewing.text = calculator(post.viewings)
            }

            binding.imageToSend.setOnClickListener{
                viewModel.toSends()
            }

            binding.imageLike.setOnClickListener{
                viewModel.like()
            }

            binding.imageViewing.setOnClickListener{
                viewModel.viewing()
            }

        })
    }
}
