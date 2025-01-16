package com.allyzer.randomusertest.feature_random_user.data.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class Timezone(
    val description: String,
    val offset: String
)