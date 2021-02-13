package ru.netology.viewmodel

import androidx.lifecycle.ViewModel
import ru.netology.repository.PostRepositoriMemory
import ru.netology.repository.PostRepository

class PostViewModel: ViewModel() {
    private val repository:PostRepository = PostRepositoriMemory()
    val data = repository.get()
    fun like() = repository.like()
    fun toSends() = repository.toSends()
    fun viewing() = repository.viewing()
}