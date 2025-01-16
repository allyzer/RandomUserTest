package com.allyzer.randomusertest.feature_random_user.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class User(
    val cell: String,
    val gender: String,
    val nat: String,
    val phone: String,
    val title: String,
    val first: String,
    val last: String,
    val streetNumber: Int,
    val streetName: String,
    val city: String,
    val state: String,
    val country: String,
    val postcode: String,
    val pictureLarge: String,
    val pictureMedium: String,
    val pictureThumbnail: String,
    val latitude: String,
    val longitude: String,
    val offset: String,
    val description: String,
    val email: String,
    val username: String,
    val birthdate: String,
    val age: Int,
    val dateRegistered: String,
    val ageRegistered: Int,
    val idName: String?,
    val idValue: String?,
)
