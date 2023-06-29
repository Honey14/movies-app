package com.bookmyshow.feature_one.model

import javax.inject.Inject

data class VenueUiState @Inject constructor(
    val name: String?,
    val showDate: String?,
    val showTimes: List<ShowTime>
) {

    companion object {
        val DEFAULT = VenueUiState(
            name = null,
            showDate = null,
            showTimes = emptyList()
        )
    }

    fun venuesLoaded(
        name: String?,
        showDate: String?,
        showTimes: List<ShowTime>
    ): VenueUiState {
        return copy(name = name, showDate = showDate, showTimes = showTimes)
    }

    fun noVenuesFound(): VenueUiState {
        return copy(name = null, showDate = null, showTimes = emptyList())
    }
}
