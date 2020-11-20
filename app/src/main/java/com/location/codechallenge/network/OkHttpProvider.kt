package com.location.codechallenge.network

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class OkHttpProvider @Inject constructor(
private val locationService: LocationService)
{
    suspend fun getLocation() = locationService.getLocation()
}