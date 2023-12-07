package sheridan.dheripu.assignment4.ui.weather

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import sheridan.dheripu.assignment4.data.remote.OpenWeatherApiResponse


@Composable
fun WeatherScreen( viewModel: WeatherViewModel, modifier: Modifier = Modifier) {

    val state: State<WeatherUIState> = viewModel.weatherUIState
    when(val weatherUIState: WeatherUIState = state.value){
        is WeatherUIState.Loaded -> {
            WeatherCard(weatherUIState.bramptonData)
            WeatherCard(weatherUIState.mississaugaData)
            WeatherCard(weatherUIState.oakvilleData)
        }

        else -> {
            Text(
                text = "Done goofed up bro!",
                modifier = modifier
            )
        }
    }

}

@Composable
fun WeatherCard( item: OpenWeatherApiResponse) {
    Card(
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        modifier = Modifier
            .padding(8.dp)
            .height(120.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(8.dp)
        ) {
            Text(
                text = item.name ,
                style = MaterialTheme.typography.headlineMedium,
                modifier = Modifier
                    .weight(0.2f)
                    .padding(8.dp)
            )
            Column(modifier = Modifier.weight(0.8f)) {
                Text(
                    text = item.weatherDescription.main ,
                    style = MaterialTheme.typography.bodyLarge,
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 3
                )
                Text(
                    text = "Temperature: " + item.weatherData.tempInCelsius + " °C",
                    style = MaterialTheme.typography.headlineMedium,
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 2
                )
                Text(
                    text = "Feels Like: " + item.weatherData.tempInCelsius + " °C",
                    style = MaterialTheme.typography.headlineMedium,
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 2
                )
            }
        }
    }
}

