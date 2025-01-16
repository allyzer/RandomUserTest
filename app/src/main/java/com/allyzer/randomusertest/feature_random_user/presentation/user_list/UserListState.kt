package com.allyzer.randomusertest.feature_random_user.presentation.user_list

import com.allyzer.randomusertest.feature_random_user.domain.model.User

data class UserListState (
    val isLoading: Boolean = false,
    val users: List<User> = emptyList(),
    val error: String = ""
)