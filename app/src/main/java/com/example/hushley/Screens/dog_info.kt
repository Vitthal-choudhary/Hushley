package com.example.hushley.Screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHostController

@Composable
fun DogInfoScreen(navController: NavHostController, backStackEntry: NavBackStackEntry) {
    val dogId = backStackEntry.arguments?.getString("dogId")?.toInt() ?: return
    Text(text = "Dog Info for Dog $dogId", modifier = Modifier.fillMaxSize())
}