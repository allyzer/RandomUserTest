package com.allyzer.randomusertest.feature_random_user.presentation.user_details

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.navigation.toRoute
import com.allyzer.randomusertest.feature_random_user.domain.model.User
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class UserDetailViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle
) : ViewModel() {
    private val user = savedStateHandle.toRoute<User>()

    private val _state = mutableStateOf(user)
    val state: State<User> = _state
}