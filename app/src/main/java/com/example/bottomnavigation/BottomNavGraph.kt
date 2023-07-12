package com.example.bottomnavigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.bottomnavigation.screens.HomeScreen
import com.example.bottomnavigation.screens.ProfileScreen
import com.example.bottomnavigation.screens.SettingScreen

// This is the BottomNavGraph composable function
@Composable
fun BottomNavGraph(navController: NavHostController) {
    // Create a NavHost composable function with the navController and startDestination as the parameters
    NavHost(
        navController = navController,
        startDestination = BottomBarScreen.Home.route // The startDestination property is used to set the initial screen when the app starts
    ) {
        // Create a composable function for each screen using the composable function and route property of each screen
        composable(route = BottomBarScreen.Home.route) {
            HomeScreen()
        }
        composable(route = BottomBarScreen.Profile.route) {
            ProfileScreen()
        }
        composable(route = BottomBarScreen.Setting.route) {
            SettingScreen()
        }
    }
}
