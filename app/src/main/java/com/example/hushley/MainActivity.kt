package com.example.hushley

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.hushley.Navigation.Screen
import com.example.hushley.Screens.HomeScreen
import com.example.hushley.Screens.Launch
import com.example.hushley.ui.theme.HushleyTheme
import androidx.navigation.compose.composable
import com.example.hushley.Screens.Dog1Screen
import com.example.hushley.Screens.Dog2Screen
import com.example.hushley.Screens.Dog3Screen
import com.example.hushley.Screens.Dog4Screen
import com.example.hushley.Screens.Dog5Screen
import com.example.hushley.Screens.Dog6Screen
import com.example.hushley.Screens.Notification
import com.example.hushley.Screens.Profile
import com.example.hushley.Screens.Shelter1Screen
import com.example.hushley.Screens.Shelter2Screen
import com.example.hushley.Screens.Shelter3Screen
import com.example.hushley.Screens.Shelter4Screen
import com.example.hushley.Screens.Shelter5Screen
import com.example.hushley.Screens.Shelter6Screen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HushleyTheme {
                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = Screen.Launch.route
                ) {
                    composable(Screen.Launch.route) {
                        Launch(navController)
                    }
                    composable(Screen.Home.route) {
                        HomeScreen(navController)
                    }
                    composable(Screen.Notification.route) {
                        Notification(navController)
                    }
                    composable(Screen.Profile.route) {
                        Profile(navController)
                    }
                    composable(Screen.Dog1.route) {
                        Dog1Screen(navController)
                    }
                    composable(Screen.Dog2.route) {
                        Dog2Screen(navController)
                    }
                    composable(Screen.Dog3.route) {
                        Dog3Screen(navController)
                    }
                    composable(Screen.Dog4.route) {
                        Dog4Screen(navController)
                    }
                    composable(Screen.Dog5.route) {
                        Dog5Screen(navController)
                    }
                    composable(Screen.Dog6.route) {
                        Dog6Screen(navController)
                    }
                    composable(Screen.Shelter1.route) {
                        Shelter1Screen(navController)
                    }
                    composable(Screen.Shelter2.route) {
                        Shelter2Screen(navController)
                    }
                    composable(Screen.Shelter3.route) {
                        Shelter3Screen(navController)
                    }
                    composable(Screen.Shelter4.route) {
                        Shelter4Screen(navController)
                    }
                    composable(Screen.Shelter5.route) {
                        Shelter5Screen(navController)
                    }
                    composable(Screen.Shelter6.route) {
                        Shelter6Screen(navController)
                    }
                }
            }
        }
    }
}