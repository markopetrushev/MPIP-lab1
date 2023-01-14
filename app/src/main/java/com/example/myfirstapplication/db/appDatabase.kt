package com.example.myfirstapplication.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.myfirstapplication.model.Data

@Database(entities = [Data::class], version = 1)
abstract class appDatabase : RoomDatabase() {

    abstract fun movieDao(): movieListDao

    companion object {
        private var dbInstance: appDatabase? = null

        fun getInstance(context: Context): appDatabase {
            if (dbInstance == null) {
                dbInstance = createInstance(context)
            }
            return dbInstance!!
        }

        private fun createInstance(context: Context): appDatabase {
            return Room.databaseBuilder(
                context,
                appDatabase::class.java, "movielist.db"
            ).build()
        }
    }
}