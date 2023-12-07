package sheridan.dheripu.assignment4.ui.weather

import sheridan.dheripu.assignment4.data.remote.OpenWeatherApiResponse

sealed interface WeatherUIState {
    object Loading : WeatherUIState
    data class Loaded(
        val bramptonData: OpenWeatherApiResponse,
        val mississaugaData: OpenWeatherApiResponse,
        val oakvilleData: OpenWeatherApiResponse,
    ) : WeatherUIState
    object NotLoaded: WeatherUIState
}