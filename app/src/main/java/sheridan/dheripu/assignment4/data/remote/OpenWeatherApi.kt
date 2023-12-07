package sheridan.dheripu.assignment4.data.remote

import retrofit2.http.GET
import retrofit2.http.Query

interface OpenWeatherApi {
    // data/2.5/weather?q=Brampton%2Cca&APPID=f7ffc3c71e4888882ed31e2759538a3f&units=metric
    @GET("data/2.5/weather")
    suspend fun getWeatherForLocation(
        @Query("q") q: String,
        @Query("APPID") appId: String,
        @Query("units") units: String
    ): OpenWeatherApiResponse
}
