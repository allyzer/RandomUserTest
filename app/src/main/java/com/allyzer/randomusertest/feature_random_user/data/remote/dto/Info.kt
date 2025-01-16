package com.allyzer.randomusertest.feature_random_user.data.remote.dto

data class Info (
    val seed: String,
    val results: Int,
    val page: Int,
    val version: String,
)