package br.com.williamfranco.httpktorkmm.services

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.request.get
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

// interface HttpService {
    // suspend fun <T> getData(url: String): T
    // suspend inline fun <reified T> getData(url: String): T
// }

class HttpService {
    val httpClient = HttpClient(CIO) {
        expectSuccess = true
        install(Logging) {
            level = LogLevel.ALL
        }
        install(ContentNegotiation) {
            json(Json {
                prettyPrint = true
                isLenient = true
            })
        }
    }

    suspend inline fun <reified T> getData(url: String): T {
        try {
            return httpClient.get(url).body()
        } catch (e: Exception) {
            println("Service error: Failed to load data.")
            throw e
        }
    }
}
