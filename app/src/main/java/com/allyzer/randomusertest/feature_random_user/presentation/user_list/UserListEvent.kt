package com.allyzer.randomusertest.feature_random_user.presentation.user_list

sealed class UserListEvent {
    data class EnteredNumber(val value: String): UserListEvent()
    object GenerateUsers: UserListEvent()

}