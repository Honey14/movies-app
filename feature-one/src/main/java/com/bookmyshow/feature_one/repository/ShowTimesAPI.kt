package com.bookmyshow.feature_one.repository

import retrofit2.http.GET

/**
 * Created by Akshansh Dhing on 12/10/22.
 */
interface ShowTimesAPI {

    @GET("/movie_showtimes")
    fun getShowTimes(): Any
}