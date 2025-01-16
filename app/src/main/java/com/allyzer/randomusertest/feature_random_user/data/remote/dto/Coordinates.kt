package com.allyzer.randomusertest.feature_random_user.data.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class Coordinates(
    val latitude: String,
    val longitude: String
)
