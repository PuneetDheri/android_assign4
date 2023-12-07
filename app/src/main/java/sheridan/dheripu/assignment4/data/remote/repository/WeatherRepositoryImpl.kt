package sheridan.dheripu.assignment4.data.remote.repository

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import sheridan.dheripu.assignment4.data.remote.OpenWeatherApi
import sheridan.dheripu.assignment4.data.remote.OpenWeatherApiResponse
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class WeatherRepositoryImpl @Inject constructor(
    private val weatherApi: OpenWeatherApi
) : WeatherRepository {

    override suspend fun getWeatherByLocation(location: String): OpenWeatherApiResponse? {
        return  weatherApi.getWeatherForLocation(location, " f7ffc3c71e4888882ed31e2759538a3f",
            "metric")
    }

    override suspend fun  refreshWeather() = withContext(Dispatchers.IO) {
        TODO("Not yet implemented")

    }
}
