package ru.netology.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
//import ru.netology.adapter.OnLikeListener
//import ru.netology.adapter.OnToSendListener
//import ru.netology.adapter.OnVievingListener
import ru.netology.databinding.ActivityMainBinding
import ru.netology.vievmodel.PostViewModel
import ru.netology.adapter.PostAdapter

import ru.netology.utils.Calculator.calculator

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val viewModel: PostViewModel by viewModels()
        val adapter = PostAdapter {
            viewModel.likeById(it.id)
            viewModel.toSendsById(it.id)
            viewModel.viewingById(it.id)

        }


        binding.list.adapter = adapter
        viewModel.data.observe(this, { posts ->
            adapter.submitList(posts)

        })
    }


}


