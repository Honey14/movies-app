package com.bookmyshow.feature_one.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bookmyshow.feature_one.model.Venue
import com.bookmyshow.feature_one.repository.Result.NoVenues
import com.bookmyshow.feature_one.repository.Result.Success
import com.bookmyshow.feature_one.repository.ShowTimesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by Akshansh Dhing on 12/10/22.
 */
@HiltViewModel
class FeatureOneViewModel @Inject constructor(
    private val showTimesRepository: ShowTimesRepository
) : ViewModel() {
    private val _listOfVenueObservable = MutableLiveData<List<Venue>>()
    private val _error = MutableLiveData<String>()
    private val _loading = MutableLiveData<Boolean>()

    val loading: LiveData<Boolean>
        get() = _loading

    val error: LiveData<String>
        get() = _error

    val listOfVenueObservable: LiveData<List<Venue>>
        get() = _listOfVenueObservable

    fun fetchVenues() {
        viewModelScope.launch {
            _loading.value = true
            val result = showTimesRepository.getVenues()
            _loading.value = false

            when (result) {
                is Success -> _listOfVenueObservable.value = result.venues
                is NoVenues -> _error.value = result.errorMessage
            }
        }
    }
}
