package com.allyzer.randomusertest.feature_random_user.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.allyzer.randomusertest.feature_random_user.domain.model.User
import com.allyzer.randomusertest.feature_random_user.presentation.user_details.UserDetailsScreen
import com.allyzer.randomusertest.feature_random_user.presentation.user_list.UserListScreen
import com.allyzer.randomusertest.feature_random_user.presentation.util.Route
import com.allyzer.randomusertest.ui.theme.RandomUserTestTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity: ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RandomUserTestTheme {
                Surface(
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = Route.UserListScreen
                    ) {
                        composable<Route.UserListScreen> {
                            UserListScreen(navController)
                        }

                        composable<User> {
                            UserDetailsScreen(navController)
                        }
                    }
                }
            }
        }
    }
}