package com.example.myfirstapplication.model

import android.os.Parcel
import android.os.Parcelable

data class MovieCs(val id: Long, val title: String?, val description: String?, val director: String?, val actors: MutableList<String>?) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readLong(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.createStringArrayList()
    ) {
    }

    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeLong(id)
        parcel.writeString(title)
        parcel.writeString(description)
        parcel.writeString(director)
        parcel.writeStringList(actors)
    }

    companion object CREATOR : Parcelable.Creator<MovieCs> {
        override fun createFromParcel(parcel: Parcel): MovieCs {
            return MovieCs(parcel)
        }

        override fun newArray(size: Int): Array<MovieCs?> {
            return arrayOfNulls(size)
        }
    }
}