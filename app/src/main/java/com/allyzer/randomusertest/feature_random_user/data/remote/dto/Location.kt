package com.allyzer.randomusertest.feature_random_user.data.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class Location(
    val city: String,
    val country: String,
    val postcode: String,
    val state: String,
    val street: Street,
    val coordinates: Coordinates,
    val timezone: Timezone
)