package com.location.codechallenge.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import com.location.codechallenge.network.models.ApiSite
import com.location.codechallenge.repository.MapRepository
import kotlinx.coroutines.launch

class MapsViewModel @ViewModelInject constructor(
private val mapRepository: MapRepository) : ViewModel()
{
    // LiveData which will be observed by UI class (Activity) for location
    val liveLocation = MutableLiveData<List<ApiSite>>()

    init {
        // fetches a quote when ViewModel object is create
        fetchLocations()
    }

    fun fetchLocations() {
        // launch a coroutine in viewModelScope
        viewModelScope.launch {
            // call api from repository
            val location = mapRepository.getLocation()
            // publish location to LiveData
            liveLocation.postValue(location)
        }
    }
}