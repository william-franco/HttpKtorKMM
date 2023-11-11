package br.com.williamfranco.httpktor.src.features.settings.view_models

import br.com.williamfranco.httpktor.src.features.settings.models.*

import kotlinx.coroutines.flow.*

interface SettingViewModel {
    val isDarkTheme: StateFlow<ThemeModel>
    fun updateTheme(isDark: Boolean)
}

class SettingViewModelImpl : SettingViewModel {
    private val _isDarkTheme = MutableStateFlow(ThemeModel(false))
    override val isDarkTheme: StateFlow<ThemeModel> = _isDarkTheme.asStateFlow()

    override fun updateTheme(isDark: Boolean) {
        _isDarkTheme.value = ThemeModel(isDark)
    }
}
