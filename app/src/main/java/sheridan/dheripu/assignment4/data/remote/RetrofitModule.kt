package sheridan.dheripu.assignment4.data.remote

import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

    object RetrofitModule {

        private const val baseUrl =  "http://10.0.2.2:8080/api/"

        fun retrofit(): Retrofit =
            Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(MoshiConverterFactory.create())
                .build()
//        fun Assignmwnt4Api(retrofit: Retrofit): Assignment4Api =
//            retrofit.create(Assignment4Api::class.java)
    }
