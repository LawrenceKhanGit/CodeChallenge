package com.location.codechallenge.network

import com.location.codechallenge.network.models.ApiSite
import com.location.codechallenge.network.models.Constants
import retrofit2.http.GET

interface LocationService {

    @GET(Constants.RELATIVE_URL)
    suspend fun getLocation() : List<ApiSite>
}