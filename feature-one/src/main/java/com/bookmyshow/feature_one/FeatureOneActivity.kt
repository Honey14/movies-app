package com.bookmyshow.feature_one

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat.requestPermissions
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.bookmyshow.feature_one.adapter.VenueItemClickListener
import com.bookmyshow.feature_one.adapter.VenuesAdapter
import com.bookmyshow.feature_one.databinding.ActivityFeatureOneBinding
import com.bookmyshow.feature_one.model.Venue
import com.bookmyshow.feature_one.viewmodel.FeatureOneViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FeatureOneActivity : AppCompatActivity(), VenueItemClickListener {

    private val viewModel: FeatureOneViewModel by viewModels<FeatureOneViewModel>()
    private lateinit var binding: ActivityFeatureOneBinding
    private lateinit var venuesAdapter: VenuesAdapter

    private val listOfVenues
        get() = binding.listOfVenues


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityFeatureOneBinding.inflate(layoutInflater)
        setContentView(binding.root)
        filterIfImageClicked()


        if (isInternetPermissionGranted()) {
            showVenueList()
        } else {
            requestInternetPermission()
        }
    }

    private fun filterIfImageClicked() {
        var venueListObserver: Observer<List<Venue>>? = null
        venueListObserver = if (imagefilterVenues.drawable == ContextCompat.getDrawable(
                this,
                R.drawable.filter_list_off_24
            )
        ) {
            Observer { venuesUi ->
                viewModel.filterVenuesToAlphabeticalOrder(venuesUi)
                imagefilterVenues.setImageResource(R.drawable.filter_list_24)
            }
        } else {
            Observer { venuesUi ->
                viewModel.clearFilterAppliedToVenues(venuesUi)
                imagefilterVenues.setImageResource(R.drawable.filter_list_off_24)
            }
        }
        viewModel.listOfVenueObservable.observe(this, venueListObserver)
    }

    private fun showVenueList() {
        venuesAdapter = VenuesAdapter(this)
        listOfVenues.adapter = venuesAdapter
        listOfVenues.layoutManager = LinearLayoutManager(this)
        observeViewModel()
    }

    private fun observeViewModel() {
        viewModel.fetchVenues()
        viewModel.error.observe(this, Observer { error ->
            Toast.makeText(this, error, Toast.LENGTH_LONG).show()
        })
        viewModel.listOfVenueObservable.observe(this,
            Observer { listOfVenues ->
                listOfVenues?.let {
                    venuesAdapter.setVenues(it)
                }
            })
        viewModel.loading.observe(this, Observer { loading ->
            showLoading(loading)
        })
    }

    private fun showLoading(loading: Boolean?) {
        if (loading == true) {
            Toast.makeText(this, "show", Toast.LENGTH_SHORT).show()
//            binding.progressBar.show()
        } else {
            Toast.makeText(this, "hide", Toast.LENGTH_SHORT).show()
//            binding.progressBar.hide()
        }
    }

    private fun requestInternetPermission() {
        requestPermissions(
            this,
            arrayOf(Manifest.permission.INTERNET),
            1
        )
    }

    private fun isInternetPermissionGranted(): Boolean {
        return ContextCompat.checkSelfPermission(
            this,
            Manifest.permission.INTERNET
        ) == PackageManager.PERMISSION_GRANTED
    }

    override fun onVenueItemClicked(venue: Venue) {
        val intent = Intent(this, VenueDetailActivity::class.java)
        intent.putExtra("venue", venue)
        startActivity(intent)
    }
}
