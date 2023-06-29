package com.bookmyshow.feature_one

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.bookmyshow.feature_one.adapter.VenueDetailAdapter
import com.bookmyshow.feature_one.databinding.ActivityVenueDetailBinding
import com.bookmyshow.feature_one.model.Venue
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class VenueDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityVenueDetailBinding
    private lateinit var venuesAdapter: VenueDetailAdapter

    private val textVenueName
        get() = binding.textVenueName

    private val textShowDate
        get() = binding.textShowDate

    private val listOfShowTimes
        get() = binding.listOfShowTimes

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_venue_detail)
        binding = ActivityVenueDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val venue = intent.getParcelableExtra<Venue>("venue")
        if (venue != null) {

            textShowDate.text = venue.showDate
            textVenueName.text = venue.name
            venuesAdapter = VenueDetailAdapter(venueDetails = venue.showtimes!!)
            listOfShowTimes.adapter = venuesAdapter
            listOfShowTimes.layoutManager = LinearLayoutManager(this)
        }
    }
}
