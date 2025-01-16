package com.allyzer.randomusertest.feature_random_user.data.remote

import com.allyzer.randomusertest.feature_random_user.data.remote.dto.UserDto
import com.allyzer.randomusertest.feature_random_user.domain.model.User
import java.time.ZoneId
import java.time.ZoneOffset
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter

fun UserDto.toUser(): User {
    val dateTimePattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'"

    val formatter = DateTimeFormatter.ofPattern(dateTimePattern).withZone(
        ZoneOffset.UTC
    )
    val dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")

    var formattedBirthDate: String
    var formattedRegisterDate: String

    try {
        val birthDateTime =
            ZonedDateTime.parse(dob.date, formatter).withZoneSameInstant(ZoneId.systemDefault())
        formattedBirthDate = birthDateTime.format(dateFormatter)
    } catch (e: Exception) {
        formattedBirthDate = dob.date
    }

    try {
        val registerDateTime =
            ZonedDateTime.parse(registered.date, formatter).withZoneSameInstant(ZoneId.systemDefault())
        formattedRegisterDate = registerDateTime.format(dateFormatter)
    } catch (e: Exception) {
        formattedRegisterDate = registered.date
    }

    return User(
        cell = cell,
        email = email,
        gender = gender,
        nat = nat,
        phone = phone,
        title = name.title,
        first = name.first,
        last = name.last,
        streetNumber = location.street.number,
        streetName = location.street.name,
        city = location.city,
        state = location.state,
        country = location.country,
        postcode = location.postcode,
        pictureLarge = picture.large,
        pictureMedium = picture.medium,
        pictureThumbnail = picture.thumbnail,
        latitude = location.coordinates.latitude,
        longitude = location.coordinates.longitude,
        offset = location.timezone.offset,
        description = location.timezone.description,
        username = login.username,
        birthdate = formattedBirthDate,
        age = dob.age,
        dateRegistered = formattedRegisterDate,
        ageRegistered = registered.age,
        idName = id.name,
        idValue = id.value,
    )
}