package sheridan.dheripu.assignment4.data.remote

import dagger.Module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
@Module
@InstallIn(SingletonComponent::class)
    object RetrofitModule {
        private const val baseUrl =  "https://api.openweathermap.org/"
        @Provides
        @Singleton
        fun retrofit(): Retrofit =
            Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(MoshiConverterFactory.create())
                .build()

        @Provides
        @Singleton
        fun provideOpenWeatherApi(retrofit: Retrofit): OpenWeatherApi =
            retrofit.create(OpenWeatherApi::class.java)
    }
