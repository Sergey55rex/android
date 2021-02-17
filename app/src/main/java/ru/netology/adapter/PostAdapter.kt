package ru.netology.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import ru.netology.Post
import ru.netology.databinding.CardPostBinding

typealias OnLikeListener = (post: Post) ->Unit
typealias OnToSendListener = (post: Post) ->Unit
typealias OnVievingListener = (post: Post) ->Unit

class PostAdapter(

        private val onToSendListener: OnToSendListener,
        private val onVievingListener: OnVievingListener,
        private val onLikeListener: OnLikeListener,
) : ListAdapter<Post, PostViewHolder>(
        PostDiffCallback()
) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val binding = CardPostBinding.inflate(LayoutInflater.from(parent.context), parent,false)
        return PostViewHolder(binding, onLikeListener, onToSendListener, onVievingListener)
    }

    override fun onBindViewHolder(
            holder: PostViewHolder,
            position: Int,
    ) {
        val post = getItem(position)
        holder.bind(post)
    }


}



