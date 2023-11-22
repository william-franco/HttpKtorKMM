package br.com.williamfranco.httpktorkmm.android.routes

import androidx.compose.runtime.Composable
import androidx.navigation.compose.*

import br.com.williamfranco.httpktorkmm.android.views.*
import br.com.williamfranco.httpktorkmm.dependency_injector.*

@Composable
fun RoutesApp(dependencies: DependencyInjector) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "postsView"
    ) {
        composable("postsView") {
            PostView(navController, dependencies.postViewModel)
        }
        composable("settingView") {
            SettingView(navController, dependencies.settingViewModel)
        }
    }
}
