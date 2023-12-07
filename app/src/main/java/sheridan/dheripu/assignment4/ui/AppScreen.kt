package sheridan.dheripu.assignment4.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.hilt.navigation.compose.hiltViewModel
import sheridan.dheripu.assignment4.ui.weather.WeatherScreen
import sheridan.dheripu.assignment4.ui.weather.WeatherViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppScreen() {

    val viewModel: WeatherViewModel = hiltViewModel()

    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(rememberTopAppBarState())

    Scaffold(
    modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),

    topBar = {
        CenterAlignedTopAppBar(
            colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                containerColor = MaterialTheme.colorScheme.primaryContainer,
                titleContentColor = MaterialTheme.colorScheme.primary,
            ),
            title = {
                Text(
                    ("Weather App Assign 4"),
                )
            },
            actions = {
                IconButton(onClick = {  }) {
                    Icon(
                        imageVector = Icons.Filled.Refresh,
                        contentDescription = "Refresh"
                    )
                }
            },
            scrollBehavior = scrollBehavior,
        )
    },
    ) { innerPadding ->

        WeatherScreen(viewModel, Modifier.padding(innerPadding))
    }


}