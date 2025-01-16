package com.allyzer.randomusertest.feature_random_user.presentation.user_list

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.allyzer.randomusertest.common.Resource
import com.allyzer.randomusertest.feature_random_user.domain.use_case.GetUsersUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class UserListViewModel @Inject constructor(
    private val getUsersUseCase: GetUsersUseCase
) : ViewModel() {
    private val _state = mutableStateOf(UserListState())
    val state: State<UserListState> = _state

    private val _numberUsers = mutableStateOf(UserListTextFieldState())
    val numberUsers: State<UserListTextFieldState> = _numberUsers

    fun onEvent(event: UserListEvent) {
        when (event) {
            is UserListEvent.EnteredNumber -> {
                _numberUsers.value = numberUsers.value.copy(
                    text = event.value
                )
            }

            is UserListEvent.GenerateUsers -> {
                viewModelScope.launch {
                    try {
                        if (numberUsers.value.text.isBlank()) {
                            throw IllegalArgumentException("The number field must not be empty.")
                        }

                        getUsers(numberUsers.value.text.trim().toInt())
                    } catch (e: NumberFormatException) {
                        _state.value = UserListState(
                            error = "The number field must contain numbers only."
                        )
                    } catch (e: IllegalArgumentException) {
                        _state.value = UserListState(
                            error = e.message ?: "An error has occurred."
                        )
                    }
                }
            }
        }
    }

    private suspend fun getUsers(count: Int) {
        getUsersUseCase(count).onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.value = UserListState(users = result.data ?: emptyList())
                }

                is Resource.Error -> {
                    _state.value = UserListState(
                        error = result.message ?: "An unexpected error has occurred."
                    )
                }

                is Resource.Loading -> {
                    _state.value = UserListState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}