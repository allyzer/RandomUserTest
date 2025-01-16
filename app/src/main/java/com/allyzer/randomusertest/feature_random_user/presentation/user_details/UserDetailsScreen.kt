package com.allyzer.randomusertest.feature_random_user.presentation.user_details

import android.R
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil3.compose.AsyncImage
import com.allyzer.randomusertest.ui.theme.DarkGray

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UserDetailsScreen(
    navController: NavController,
    viewModel: UserDetailViewModel = hiltViewModel()
) {
    val user = viewModel.state.value

    Scaffold(
        topBar = {
            TopAppBar(
                colors = topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                ),
                title = {
                    Text("User details")
                },
                navigationIcon = {
                    IconButton(
                        onClick = {
                            navController.navigateUp()
                        }
                    ) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Back"
                        )
                    }
                },
            )
        },
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding),
            verticalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                contentPadding = PaddingValues(20.dp)
            ) {
                item {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        AsyncImage(
                            model = user.pictureLarge,
                            contentDescription = "avatar",
                            modifier = Modifier.size(128.dp)
                                .clip(CircleShape)
                                .border(1.dp, color = DarkGray, CircleShape),
                            error = painterResource(R.drawable.ic_menu_report_image),
                        )
                    }
                    Spacer(modifier = Modifier.height(16.dp))
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = "${user.title}. ${user.first} ${user.last}",
                            style = MaterialTheme.typography.displayMedium,
                        )
                    }
                    Spacer(modifier = Modifier.height(16.dp))

                    TextField(
                        value = user.username,
                        onValueChange = { },
                        readOnly = true,
                        label = { Text("Username") },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp),
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    TextField(
                        value = user.email,
                        onValueChange = { },
                        readOnly = true,
                        label = { Text("Email Address") },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp),
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    TextField(
                        value = user.phone,
                        onValueChange = { },
                        readOnly = true,
                        label = { Text("Phone") },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp),
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    TextField(
                        value = user.cell,
                        onValueChange = { },
                        readOnly = true,
                        label = { Text("Cell") },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp),
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    TextField(
                        value = "${user.streetNumber} ${user.streetName} ${user.city}"
                                + " ${user.state} ${user.country} ${user.postcode}",
                        onValueChange = { },
                        readOnly = true,
                        label = { Text("Address") },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp),
                    )

                    Spacer(modifier = Modifier.height(8.dp))
                    TextField(
                        value = user.cell,
                        onValueChange = { },
                        readOnly = true,
                        label = { Text("Cell") },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp),
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    TextField(
                        value = user.birthdate,
                        onValueChange = { },
                        readOnly = true,
                        label = { Text("Birthdate") },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp),
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    TextField(
                        value = user.age.toString(),
                        onValueChange = { },
                        readOnly = true,
                        label = { Text("Age") },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp),
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    TextField(
                        value = user.dateRegistered,
                        onValueChange = { },
                        readOnly = true,
                        label = { Text("Date Registered") },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp),
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    TextField(
                        value = user.ageRegistered.toString(),
                        onValueChange = { },
                        readOnly = true,
                        label = { Text("Age Registered") },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp),
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    TextField(
                        value = user.nat,
                        onValueChange = { },
                        readOnly = true,
                        label = { Text("Nationality") },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp),
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    TextField(
                        value = "${user.latitude}, ${user.longitude}",
                        onValueChange = { },
                        readOnly = true,
                        label = { Text("Location") },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp),
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    TextField(
                        value = "${user.offset} UTC",
                        onValueChange = { },
                        readOnly = true,
                        label = { Text("Timezone") },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp),
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    TextField(
                        value = user.description,
                        onValueChange = { },
                        readOnly = true,
                        label = { Text("Timezone description") },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp),
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    TextField(
                        value = user.idName ?: "",
                        onValueChange = { },
                        readOnly = true,
                        label = { Text("Id") },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp),
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    TextField(
                        value = user.idValue ?: "",
                        onValueChange = { },
                        readOnly = true,
                        label = { Text("Id number") },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp),
                    )
                }
            }
        }
    }
}