package com.example.myfirstapplication.API

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class omdbApiClient {

    companion object {
        private var omdbApi: omdbApi? = null
        val apiKey = "921feb99";

        fun getOmdbApi(): omdbApi? {

            if(omdbApi == null) {
                omdbApi = Retrofit.Builder()
                    .baseUrl("http://www.omdbapi.com")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                    .create(omdbApi::class.java)
            }

            return omdbApi
        }
    }
}