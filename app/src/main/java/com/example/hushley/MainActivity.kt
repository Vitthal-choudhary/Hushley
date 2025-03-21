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
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.hushley.Screens.Notification
import com.example.hushley.Screens.Profile

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
                        Notification()
                    }
                    composable(Screen.Profile.route) {
                        Profile()
                    }
                }
            }
        }
    }
}