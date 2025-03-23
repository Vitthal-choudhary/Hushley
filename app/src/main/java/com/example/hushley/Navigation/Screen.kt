package com.example.hushley.Navigation

sealed class Screen(val route: String) {
    object Launch : Screen("launch")
    object Home : Screen("home")
    object Notification : Screen("notification")
    object Profile : Screen("profile")
    object Dog1 : Screen("dog1")
    object Dog2 : Screen("dog2")
    object Dog3 : Screen("dog3")
    object Dog4 : Screen("dog4")
    object Dog5 : Screen("dog5")
    object Dog6 : Screen("dog6")
    object Shelter1 : Screen("shelter1")
    object Shelter2 : Screen("shelter2")
    object Shelter3 : Screen("shelter3")
    object Shelter4 : Screen("shelter4")
    object Shelter5 : Screen("shelter5")
    object Shelter6 : Screen("shelter6")
}