package com.example.bottomnavigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector

// This is the BottomBarScreen sealed class
sealed class BottomBarScreen(
    val route: String, // The route property is used to navigate to the corresponding screen using the Navigation component
    val title: String, // The title property is used as the label for the bottom navigation bar item
    val icon: ImageVector // The icon property is used as the icon for the bottom navigation bar item
)
{
    // This is the Home subclass of the BottomBarScreen sealed class
    object Home :BottomBarScreen(
        route = "home",
        title = "Home",
        icon = Icons.Default.Home
    )

    // This is the Profile subclass of the BottomBarScreen sealed class
    object Profile :BottomBarScreen(
        route = "profile",
        title = "Profile",
        icon = Icons.Default.Person
    )

    // This is the Setting subclass of the BottomBarScreen sealed class
    object Setting :BottomBarScreen(
        route = "setting",
        title = "Setting",
        icon = Icons.Default.Settings
    )
}
