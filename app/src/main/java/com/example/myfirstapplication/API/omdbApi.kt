package com.example.myfirstapplication.API
import com.example.myfirstapplication.model.MovieList
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface omdbApi {

    @GET(".")
    fun getMoviesByTitle(@Query("apikey") apiKey: String,
                         @Query("page") page: String,
                         @Query("type") type: String,
                         @Query("s") s: String): Call<MovieList>
}