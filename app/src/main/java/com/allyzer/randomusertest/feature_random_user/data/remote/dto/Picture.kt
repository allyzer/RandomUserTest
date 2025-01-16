package com.allyzer.randomusertest.feature_random_user.data.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class Picture(
    val large: String,
    val medium: String,
    val thumbnail: String
)