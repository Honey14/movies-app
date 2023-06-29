package com.bookmyshow.feature_one.model

import android.os.Parcelable
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@JsonClass(generateAdapter = true)
@Parcelize
data class Showtimes(
    val showTime: String,
    val showDateCode: Int
) : Parcelable
