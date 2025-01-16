package com.allyzer.randomusertest.feature_random_user.presentation.user_list

import androidx.compose.foundation.gestures.snapping.SnapPosition
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil3.compose.AsyncImage
import com.allyzer.randomusertest.common.TestTags
import com.allyzer.randomusertest.feature_random_user.presentation.user_list.components.UserListItem

@Composable
fun UserListScreen (
    navController: NavController,
    viewModel: UserListViewModel = hiltViewModel()
) {
    val state = viewModel.state.value
    val numberUsers = viewModel.numberUsers.value

    Box {
        Scaffold { innerPadding ->
            Column(
                modifier = Modifier
                    .padding(innerPadding),
                verticalArrangement = Arrangement.spacedBy(16.dp),
            ) {
                OutlinedTextField(
                    value = numberUsers.text,
                    onValueChange = {
                        viewModel.onEvent(UserListEvent.EnteredNumber(it))
                    },
                    label = { Text("Enter the number of users to generate") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                        .testTag(TestTags.NUMBER_TEXT_FIELD),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                )

                Button(
                    onClick = {
                        viewModel.onEvent(UserListEvent.GenerateUsers)
                    },
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .testTag(TestTags.GENERATE_BUTTON)
                ) {
                    Text("Generate random users")
                }

                Box(modifier = Modifier.fillMaxSize()) {
                    LazyColumn(modifier = Modifier.fillMaxSize()) {
                        items(state.users) { user ->
                            UserListItem(user = user,
                                onItemClick = {
                                    navController.navigate(user)
                                })
                        }
                    }
                }
            }
        }

        if (state.error.isNotBlank()) {
            Text(
                text = state.error,
                color = MaterialTheme.colorScheme.error,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
                    .align(Alignment.Center)
            )
        }

        if (state.isLoading) {
            CircularProgressIndicator(
                modifier = Modifier
                    .align(Alignment.Center)
                    .testTag(TestTags.PROGRESS_INDICATOR)
            )
        }
    }
}