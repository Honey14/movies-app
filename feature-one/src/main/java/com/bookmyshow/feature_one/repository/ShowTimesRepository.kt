package com.bookmyshow.feature_one.repository

import com.bookmyshow.core.NetworkProvider
import com.bookmyshow.feature_one.model.Venue
import com.bookmyshow.feature_one.model.Venues
import com.squareup.moshi.Moshi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject
import kotlin.Exception

/**
 * Created by Akshansh Dhing on 12/10/22.
 */
class ShowTimesRepository @Inject constructor(
    private val networkProvider: NetworkProvider,
    private val moshi: Moshi
) : AbstractedShowTimes {
    // please pardon the naming convention that is already present, I will not be changing those for easy reviewing capabilities
    private val api: ShowTimesAPI
        get() = networkProvider.getApi(
            apiClass = ShowTimesAPI::class.java,
            baseUrl = "https://demo2782755.mockable.io",
            moshi = moshi
        )

    override suspend fun getVenues(): Result<List<Venue>> {
        return withContext(Dispatchers.IO)
        {
            try {
                val venues = api.getShowTimes()
                fetchVenues(venues)
            } catch (e: Exception) {
                Result.NoVenues(e.message ?: "An error occurred")
            }
        }
    }

    override fun filterVenuesToAlphabeticalOrder(listOfVenues: List<Venue>): List<Venue> {
        return listOfVenues.sortedBy { it.name }
    }

    override fun clearFilterAppliedToVenues(listOfVenues: List<Venue>): List<Venue> {
        return listOfVenues.asReversed()
    }

    private fun fetchVenues(venues: Venues?): Result<List<Venue>> {
        return if (venues != null && venues.venues.isNotEmpty()) {
            Result.Success(venues.venues)
        } else {
            Result.NoVenues("No Venues Found")
        }
    }
}


sealed class Result<out T> {
    data class Success<out T>(val venues: T) : Result<T>()
    data class NoVenues(val errorMessage: String) : Result<Nothing>()
}
