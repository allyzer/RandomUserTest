package com.allyzer.randomusertest.feature_random_user.data.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class Street(
    val name: String,
    val number: Int
)