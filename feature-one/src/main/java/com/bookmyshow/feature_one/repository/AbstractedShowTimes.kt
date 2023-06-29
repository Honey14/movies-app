package com.bookmyshow.feature_one.repository

import com.bookmyshow.feature_one.model.Venue

interface AbstractedShowTimes {
    suspend fun getVenues(): Result<List<Venue>>
    fun filterVenuesToAlphabeticalOrder(listOfVenues: List<Venue>): List<Venue>
    fun clearFilterAppliedToVenues(listOfVenues: List<Venue>): List<Venue>
}
