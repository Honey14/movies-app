package com.bookmyshow.feature_one.model

import android.os.Parcelable
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@JsonClass(generateAdapter = true)
@Parcelize
data class Venues(
    val venues: List<Venue>
) : Parcelable
