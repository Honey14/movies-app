package com.bookmyshow.feature_one.adapter

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bookmyshow.feature_one.R
import com.bookmyshow.feature_one.model.Venue


class VenuesAdapter(
    private val listener: VenueItemClickListener
) : RecyclerView.Adapter<VenuesAdapter.VenuesViewHolder>() {

    val venues = mutableListOf<Venue>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VenuesViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.venue_list_item, parent, false)

        return VenuesViewHolder(view)
    }

    override fun getItemCount(): Int {
        return venues.size
    }

    override fun onBindViewHolder(holder: VenuesViewHolder, position: Int) {
        val venue = venues[position]
        holder.textVenueName.text = venue.name
        holder.textShowDate.text = venue.showDate
        holder.textShowDate.setOnClickListener {
            listener.onVenueItemClicked(venue = venue)
        }
    }

    inner class VenuesViewHolder(view: View) : ViewHolder(view) {
        val textVenueName: TextView
        val textShowDate: TextView

        init {
            textVenueName = view.findViewById(R.id.textVenueName)
            textShowDate = view.findViewById(R.id.textShowDate)
        }
    }


    private val venuesDiffCallback = object : DiffUtil.ItemCallback<Venue>() {
        override fun areItemsTheSame(oldItem: Venue, newItem: Venue): Boolean {
            val areShowTimesSame = oldItem.showtimes == newItem.showtimes
            val isShowDateSame = oldItem.showDate == newItem.showDate
            val isVenueSame = oldItem.name == newItem.name

            return areShowTimesSame && isShowDateSame && isVenueSame
        }

        override fun areContentsTheSame(oldItem: Venue, newItem: Venue): Boolean {
            return oldItem == newItem
        }
    }

    val differ = AsyncListDiffer(this, venuesDiffCallback)

    fun setVenues(venues: List<Venue>) {
        differ.submitList(venues)
    }
}
