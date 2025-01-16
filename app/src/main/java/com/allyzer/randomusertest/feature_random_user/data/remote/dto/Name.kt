package com.allyzer.randomusertest.feature_random_user.data.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class Name(
    val first: String,
    val last: String,
    val title: String
)