package com.location.codechallenge.network.models

import kotlinx.serialization.Serializable

@Serializable
data class ApiSite(
    var name: String,
    var lat: String,
    var long: String
)