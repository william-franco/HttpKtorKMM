package br.com.williamfranco.httpktorkmm.features.posts.repositories

import br.com.williamfranco.httpktorkmm.environments.Environments
import br.com.williamfranco.httpktorkmm.features.posts.models.PostModel
import br.com.williamfranco.httpktorkmm.services.HttpService

interface PostRepository {
    suspend fun getPosts(): List<PostModel>
}

class PostRepositoryImpl(private val httpService: HttpService) : PostRepository {
    private val endpoint = Environments.baseURL + Environments.posts

    override suspend fun getPosts(): List<PostModel> {
        try {
            return httpService.getData(endpoint)
        } catch (e: Exception) {
            println("Repository error: Failed to load data.")
            throw e
        }
    }
}
