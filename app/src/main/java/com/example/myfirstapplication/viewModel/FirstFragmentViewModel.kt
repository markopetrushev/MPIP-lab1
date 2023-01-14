package com.example.myfirstapplication.viewModel

import android.app.Application
import android.telecom.Call
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.myfirstapplication.API.omdbApi
import com.example.myfirstapplication.db.appDatabase
import com.example.myfirstapplication.model.MovieList
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FirstFragmentViewModel(application: Application): AndroidViewModel(application) {

    private var omdbApiClient: omdbApi = omdbApiClient.getOmdbApi()!!
    private var app: Application = application
    private var movieListMutableLiveData: MutableLiveData<MovieList> = MutableLiveData()
    private val database: appDatabase = appDatabase.getInstance(application)

    fun searchMoviesByTitle(title: String){
        omdbApiClient.getMoviesByTitle("921feb99", "1", "movie", title).enqueue(object :
            Callback<MovieList> {
            override fun onResponse(call: android.telecom.Call<MovieList>?, response: Response<MovieList>) {
                if (response.body() != null){
                    val movies: MovieList = response.body()
                    saveMovieListInDatabase(movies)
                    movieListMutableLiveData.postValue(movies)
                    Toast.makeText(app, "Success!", Toast.LENGTH_LONG).show()
                }else {
                    Toast.makeText(app, "Error", Toast.LENGTH_LONG).show()
                }

            }

            override fun onFailure(call: android.telecom.Call<MovieList>?, t: Throwable) {
                Toast.makeText(app, t.message, Toast.LENGTH_LONG).show()
            }
        })
    }

    private fun saveMovieListInDatabase(currentMovieList: MovieList) {
        CoroutineScope(Dispatchers.IO).launch {
            database.movieDao().insertDatas(currentMovieList.Search)
        }
    }

    fun getMovieListMutableLiveData(): MutableLiveData<MovieList>{
        return movieListMutableLiveData;
    }
}