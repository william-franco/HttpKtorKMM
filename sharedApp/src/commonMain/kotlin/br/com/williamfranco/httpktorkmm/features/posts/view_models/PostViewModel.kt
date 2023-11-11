package br.com.williamfranco.httpktorkmm.features.posts.view_models

import br.com.williamfranco.httpktorkmm.features.posts.models.PostModel
import br.com.williamfranco.httpktorkmm.features.posts.repositories.PostRepository

import dev.icerock.moko.mvvm.viewmodel.ViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

interface PostViewModel {
    val posts: StateFlow<List<PostModel>>
    val isLoading: StateFlow<Boolean>

    fun refreshPosts()
}

class PostViewModelImpl(private val postRepository: PostRepository) : ViewModel(), PostViewModel {
    private val _posts = MutableStateFlow<List<PostModel>>(emptyList())
    override val posts: StateFlow<List<PostModel>> get() = _posts

    private val _isLoading = MutableStateFlow<Boolean>(true)
    override val isLoading: StateFlow<Boolean> get() = _isLoading

    init {
        fetchPosts()
    }

    override fun refreshPosts() {
        _isLoading.value = true
        fetchPosts()
    }

    private fun fetchPosts() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val fetchedPosts = postRepository.getPosts()
                withContext(Dispatchers.Main) {
                    _posts.value = fetchedPosts
                }
            } catch (e: Exception) {
                println("ViewModel error: Failed to load data.")
                throw e
            } finally {
                _isLoading.value = false
            }
        }
    }
}

//class PostViewModel(private val postRepository: PostRepository) : ViewModel() {
//    private val _posts = MutableStateFlow<List<PostModel>>(emptyList())
//    val posts: StateFlow<List<PostModel>> get() = _posts
//
//    private val _isLoading = MutableStateFlow<Boolean>(true)
//    val isLoading: StateFlow<Boolean> get() = _isLoading
//
//    init {
//        fetchPosts()
//    }
//
//    fun refreshPosts() {
//        _isLoading.value = true
//        fetchPosts()
//    }
//
//    private fun fetchPosts() {
//        viewModelScope.launch(Dispatchers.IO) {
//            try {
//                _posts.value = postRepository.getPosts()
//            } catch (e: Exception) {
//                println("$e")
//                // Log.d("PostViewModel", "Exception ${e.message}")
//            } finally {
//                _isLoading.value = false
//            }
//        }
//    }
//}
