package com.bookmyshow.feature_one

import com.bookmyshow.feature_one.model.Venue
import com.bookmyshow.feature_one.repository.Result
import com.bookmyshow.feature_one.repository.ShowTimesRepository
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Test
import org.junit.Assert.*
import org.mockito.Mockito.*

class ShowTimesRepositoryTest {

    private val showTimesRepository = mock<ShowTimesRepository>()

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun `when the venues are fetched, then update the list of venues`() {
        // Given
        val venueDetails = mock<Result.Success<List<Venue>>>()
        val venues = mock<List<Venue>>()

        //when
        runTest {
            `when`(showTimesRepository.getVenues()).thenReturn(venueDetails)
        }

        // then
        assertEquals(venues, venueDetails.venues)
    }


    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun `when there were no venues, then do not update the list`() {
        // Given
        val venueDetails = mock<Result.NoVenues>()
        val errorMessage = "No Venues Found"

        //when
        runTest {
            `when`(showTimesRepository.getVenues()).thenReturn(venueDetails)
        }

        // then
        assertEquals(errorMessage, venueDetails.errorMessage)
    }
}