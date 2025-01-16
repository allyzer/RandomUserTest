package com.allyzer.randomusertest.feature_random_user.presentation.util

import kotlinx.serialization.Serializable

sealed interface Route {
    @Serializable
    data object UserListScreen
}
