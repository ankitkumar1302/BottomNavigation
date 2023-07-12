@file:OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterial3Api::class)

package com.example.bottomnavigation

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.RowScope
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
// This is the main screen composable function
@Composable
fun MainScreen() {
    // Create a navController using the rememberNavController function
    val navController = rememberNavController()

    // Create a Scaffold composable function with a BottomBar as the bottom bar
    Scaffold(
        bottomBar = { BottomBar(navController = navController) }
    ) {
        // Create a BottomNavGraph composable function with the navController as the parameter
        BottomNavGraph(navController = navController)
    }
}

// This is the BottomBar composable function
@Composable
fun BottomBar(navController: NavHostController) {
    // Define a list of screens for the bottom navigation bar
    val screens = listOf(
        BottomBarScreen.Home,
        BottomBarScreen.Profile,
        BottomBarScreen.Setting,
    )

    // Get the current destination from the navBackStackEntry using currentBackStackEntryAsState function
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    // Create a BottomAppBar composable function with a RowScope as the parameter
    BottomAppBar {
        // Loop through each screen in the screens list and create an item for each screen using the AddItem composable function
        screens.forEach { screen ->
            AddItem(
                screen = screen,
                currentDestination = currentDestination,
                navController = navController
            )
        }
    }
}

// This is the AddItem composable function
@Composable
fun RowScope.AddItem(
    screen: BottomBarScreen,
    currentDestination: NavDestination?,
    navController: NavHostController
) {
    // Create a NavigationBarItem composable function with label, icon, selected, and onClick parameters
    NavigationBarItem(
        label = {
            Text(text = screen.title)
        },
        icon = {
            Icon(imageVector = screen.icon, contentDescription = "Navigation Icon")
        },
        selected = currentDestination?.hierarchy?.any {
            it.route == screen.route
        } == true,
        onClick = {
            navController.navigate(screen.route) {
                popUpTo(navController.graph.findStartDestination().id)
                launchSingleTop = true
            }
        }
    )
}
