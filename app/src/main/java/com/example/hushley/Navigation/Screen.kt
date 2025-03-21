package com.example.hushley.Navigation

sealed class Screen(val route: String) {
    object Launch : Screen("launch")
    object Home : Screen("home")
    object Notification : Screen("notification")
    object Profile : Screen("profile")
}