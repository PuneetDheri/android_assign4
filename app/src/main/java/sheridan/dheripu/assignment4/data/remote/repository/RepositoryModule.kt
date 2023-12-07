package sheridan.dheripu.assignment4.data.remote.repository

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import sheridan.dheripu.assignment4.data.remote.repository.WeatherRepository
import sheridan.dheripu.assignment4.data.remote.repository.WeatherRepositoryImpl

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindRestaurantRepository(
        repository: WeatherRepositoryImpl
    ): WeatherRepository
}