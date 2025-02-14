package com.allyzer.randomusertest.feature_random_user.data.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class Login(
    val md5: String,
    val password: String,
    val salt: String,
    val sha1: String,
    val sha256: String,
    val username: String,
    val uuid: String
)