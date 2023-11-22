package br.com.williamfranco.httpktorkmm.dependency_injector

import br.com.williamfranco.httpktorkmm.features.posts.repositories.*
import br.com.williamfranco.httpktorkmm.features.posts.view_models.*
import br.com.williamfranco.httpktorkmm.features.settings.view_models.SettingViewModel
import br.com.williamfranco.httpktorkmm.features.settings.view_models.SettingViewModelImpl
import br.com.williamfranco.httpktorkmm.services.HttpService

class DependencyInjector {
    // Services
    private val httpService = HttpService()
    // Repositories
    private val postRepository: PostRepository = PostRepositoryImpl(httpService)
    // ViewModels
    val postViewModel: PostViewModel = PostViewModelImpl(postRepository)
    val settingViewModel: SettingViewModel = SettingViewModelImpl()
}
