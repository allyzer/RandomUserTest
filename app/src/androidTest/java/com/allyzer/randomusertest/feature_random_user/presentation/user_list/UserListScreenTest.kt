package com.allyzer.randomusertest.feature_random_user.presentation.user_list

import androidx.activity.compose.setContent
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.allyzer.randomusertest.common.TestTags
import com.allyzer.randomusertest.di.AppModule
import com.allyzer.randomusertest.feature_random_user.domain.model.User
import com.allyzer.randomusertest.feature_random_user.presentation.MainActivity
import com.allyzer.randomusertest.feature_random_user.presentation.user_details.UserDetailsScreen
import com.allyzer.randomusertest.feature_random_user.presentation.util.Route
import com.allyzer.randomusertest.ui.theme.RandomUserTestTheme
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import dagger.hilt.android.testing.UninstallModules
import org.junit.Before
import org.junit.Rule
import org.junit.Test


@HiltAndroidTest
@UninstallModules(AppModule::class)
class UserListScreenTest {

    @get:Rule(order = 0)
    val hiltRule = HiltAndroidRule(this)

    @get:Rule(order = 1)
    val composeRule = createAndroidComposeRule<MainActivity>()

    @Before
    fun setUp() {
        hiltRule.inject()
        composeRule.activity.setContent {
            val navController = rememberNavController()
            RandomUserTestTheme() {
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

    @Test
    fun enterNumber_isLoading() {
        //Enter number in text field
        composeRule
            .onNodeWithTag(TestTags.NUMBER_TEXT_FIELD)
            .performTextInput("5")

        //click generate button
        composeRule.onNodeWithTag(TestTags.GENERATE_BUTTON).performClick()

        //check if loading is showing
        composeRule.onNodeWithTag(TestTags.PROGRESS_INDICATOR).assertIsDisplayed()
    }
}