package com.example.myfirstapplication.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Data(@PrimaryKey(autoGenerate = true) val id: Long = 0,
                val Title: String = "",
                val Year: String = "",
                val Poster: String = "")