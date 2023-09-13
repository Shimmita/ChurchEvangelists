package com.shimitadouglas.uet.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.shimitadouglas.uet.routes.Routes
import com.shimitadouglas.uet.screens.Home
import com.shimitadouglas.uet.screens.Members
import com.shimitadouglas.uet.screens.Notification
import com.shimitadouglas.uet.screens.Profile

@Composable
fun Nav(navigationController: NavHostController) {
    //creating navigation controller for routing
    //creating the navHost
    NavHost(
        navController = navigationController,
        startDestination = Routes.HOME_SCREEN
    ) {
        composable(route = Routes.HOME_SCREEN) {
            Home(navigationController)
        }

        composable(route = Routes.MEMBERS_SCREEN) {
            Members(navigationController)
        }

        composable(route = Routes.PROFILE_SCREEN) {
            Profile(navigationController)
        }
        composable(route = Routes.NOTIFICATION_SCREEN) {
            Notification(navigationController)
        }

    }
}