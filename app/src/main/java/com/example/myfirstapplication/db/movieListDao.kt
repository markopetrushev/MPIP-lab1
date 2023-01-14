package com.example.myfirstapplication.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.myfirstapplication.model.Data

@Dao
abstract class movieListDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insertDatas(data: MutableList<Data>)

    @Query("SELECT * FROM Data WHERE title = :title")
    abstract fun getMovies(title: String): List<Data>
}