package br.com.williamfranco.httpktorkmm.android.Routes

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

import br.com.williamfranco.httpktorkmm.android.Views.PostView
import br.com.williamfranco.httpktorkmm.features.posts.repositories.*
import br.com.williamfranco.httpktorkmm.features.posts.view_models.*
import br.com.williamfranco.httpktorkmm.services.HttpService

@Composable
fun RoutesApp() {
    val navController = rememberNavController()

    val httpService = HttpService()
    val postRepository: PostRepository = PostRepositoryImpl(httpService)
    val postViewModel: PostViewModel = PostViewModelImpl(postRepository)
    // val settingViewModel: SettingViewModel = SettingViewModelImpl()

    NavHost(
        navController = navController,
        startDestination = "postsView"
    ) {
        composable("postsView") {
            PostView(postViewModel)
        }
//        composable("settingView") {
//            SettingView(navController, settingViewModel)
//        }
    }
}
