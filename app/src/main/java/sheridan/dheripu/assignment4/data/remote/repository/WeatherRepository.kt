package sheridan.dheripu.assignment4.data.remote.repository

import sheridan.dheripu.assignment4.data.remote.OpenWeatherApiResponse

interface WeatherRepository {

    suspend fun getWeatherByLocation(location: String): OpenWeatherApiResponse?
    suspend fun refreshWeather()
}