package com.bookmyshow.feature_one

import com.bookmyshow.feature_one.model.Showtimes
import com.bookmyshow.feature_one.model.Venue
import com.bookmyshow.feature_one.repository.Result
import com.bookmyshow.feature_one.repository.ShowTimesRepository
import com.bookmyshow.feature_one.viewmodel.FeatureOneViewModel
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito
import org.mockito.Mockito.assertArg
import org.mockito.Mockito.mock
import org.mockito.Mockito.`when`
import org.mockito.kotlin.doNothing

class FeatureOneViewModelTests {
    private var viewModel = mock<FeatureOneViewModel>()
    private val showTimesRepository = mock<ShowTimesRepository>()

    @Before
    fun setup() {
        viewModel = FeatureOneViewModel(showTimesRepository)
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun `when get venues is called, then venues list is received successfully`() {
        // given
        val showTimes1 = listOf(
            Showtimes(
                showTime = "09:00am",
                showDateCode = 2020200022
            )
        )
        val showTimes2 = listOf(
            Showtimes(
                showTime = "07:45am",
                showDateCode = 2065700022
            )
        )
        val venues = listOf(
            Venue(
                name = "PVR Juhu, Mumbai Western",
                showDate = "1st May, 2022",
                showtimes = showTimes1
            ),
            Venue(
                name = "PVR Juhu, Mumbai Western",
                showDate = "1st May, 2022",
                showtimes = showTimes2
            )
        )
        val successResult = Result.Success(venues)
        // when

        val response = viewModel.fetchVenues()

        // then
        assertEquals(successResult, response.)
    }
}
}