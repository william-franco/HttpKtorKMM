package br.com.williamfranco.httpktorkmm

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform