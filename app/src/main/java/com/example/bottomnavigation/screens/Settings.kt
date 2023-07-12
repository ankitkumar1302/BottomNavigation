package com.example.bottomnavigation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

// This is the SettingScreen composable function
@Composable
fun SettingScreen() {
    // Create a Box composable function with a Modifier and contentAlignment as the parameters
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Blue), // The background property is used to set the background color of the Box

        contentAlignment = Alignment.Center // The contentAlignment property is used to align the child Text composable function in the center of the Box
    ) {
        // Create a Text composable function with text, fontSize, color, and fontWeight as the parameters
        Text(
            text = "Setting",
            fontSize = 36.sp,
            color = Color.White,
            fontWeight = FontWeight.Bold
        )
    }
}

// This is the SettingPreview composable function
@Preview
@Composable
fun SettingPreview() {
    SettingScreen()
}
