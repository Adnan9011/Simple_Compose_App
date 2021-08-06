package com.example.simple_compose_app.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class Movie(
    val name: String,
    val posterImage: String,
    val backdropImage: String,
    val overview: String
) : Parcelable