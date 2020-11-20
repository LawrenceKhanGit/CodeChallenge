package com.location.codechallenge.repository

import com.location.codechallenge.network.OkHttpProvider
import javax.inject.Inject

class MapRepository @Inject constructor(
private val okHttpProvider: OkHttpProvider)
{

    suspend fun getLocation() = okHttpProvider.getLocation()

}