package com.bookmyshow.feature_one.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bookmyshow.feature_one.R
import com.bookmyshow.feature_one.model.Showtimes

class VenueDetailAdapter(
    private val venueDetails: List<Showtimes>
) : RecyclerView.Adapter<VenueDetailAdapter.VenueDetailViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): VenueDetailAdapter.VenueDetailViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.venue_detail_list_item, parent, false)

        return VenueDetailViewHolder(view)
    }

    override fun onBindViewHolder(holder: VenueDetailAdapter.VenueDetailViewHolder, position: Int) {
        val venue = venueDetails[position]
        holder.textShowTime.text = venue.showTime
    }

    override fun getItemCount(): Int {
        return venueDetails.size
    }

    inner class VenueDetailViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textShowTime: TextView

        init {
            textShowTime = view.findViewById(R.id.textShowTime)
        }
    }
}
