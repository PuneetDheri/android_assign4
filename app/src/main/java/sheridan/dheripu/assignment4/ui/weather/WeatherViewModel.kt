package sheridan.dheripu.assignment4.ui.weather

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import sheridan.dheripu.assignment4.data.remote.repository.WeatherRepositoryImpl
import javax.inject.Inject

@HiltViewModel
class WeatherViewModel @Inject constructor(
    weatherRepository: WeatherRepositoryImpl
) : ViewModel() {

    private val _weatherUIState: MutableState<WeatherUIState> =
        mutableStateOf(WeatherUIState.Loading)
    val weatherUIState: State<WeatherUIState> = _weatherUIState


    init {
        viewModelScope.launch {
            val mississaugaData = weatherRepository.getWeatherByLocation("Mississauga%2CCA")!!
            val bramptonData = weatherRepository.getWeatherByLocation("Brampton%2CCA")!!
            val oakvilleData = weatherRepository.getWeatherByLocation("Oakville%2CCA")!!

            if (bramptonData != null && mississaugaData != null && oakvilleData != null) {
                Log.e("WeatherViewModel", "data for Mississauga: $mississaugaData ")
                Log.e("WeatherViewModel", "data for all  bramptonData: $bramptonData")
                Log.e("WeatherViewModel", "data for all  oakvilleData: $oakvilleData")

                _weatherUIState.value = WeatherUIState.Loaded(
                    bramptonData = bramptonData,
                    mississaugaData = mississaugaData,
                    oakvilleData = oakvilleData
                )
            } else {
                _weatherUIState.value = WeatherUIState.NotLoaded
                Log.e("WeatherViewModel", "data for id=$bramptonData is not found")

            }
        }
    }

}



