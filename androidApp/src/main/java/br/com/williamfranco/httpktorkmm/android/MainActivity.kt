package br.com.williamfranco.httpktorkmm.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme

import br.com.williamfranco.httpktorkmm.android.routes.*
import br.com.williamfranco.httpktorkmm.dependency_injector.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val dependencies = DependencyInjector()

        setContent {
            MaterialTheme {
                RoutesApp(dependencies)
            }
        }
    }
}
