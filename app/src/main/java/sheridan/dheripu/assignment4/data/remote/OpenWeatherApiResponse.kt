package sheridan.dheripu.assignment4.data.remote

import com.google.gson.annotations.SerializedName

data class OpenWeatherApiResponse(
    @SerializedName("base")
    val base: String,
    @SerializedName("main")
    val weatherData: WeatherData,

    @SerializedName("weather")
    val weatherDescription: WeatherDescription,


    @SerializedName("dt")
    val dt: Int,
    @SerializedName("name")
    val name: String,



    )


data class WeatherData (
    @SerializedName("temp")
    val tempInCelsius: Int,
    @SerializedName("feels_like")
    val feelsLikeTemperature: String,
    @SerializedName("pressure")
    val pressure: String,
    @SerializedName("humidity")
    val humidity: String,
)


   data class WeatherDescription (
       @SerializedName("main")
       val main: String,
       @SerializedName("description")
       val description: String,
       @SerializedName("icon")
       val icon: String

   )
