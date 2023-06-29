package com.bookmyshow.feature_one.adapter

import com.bookmyshow.feature_one.model.Venue

interface VenueItemClickListener {
    fun onVenueItemClicked(venue: Venue)
}
