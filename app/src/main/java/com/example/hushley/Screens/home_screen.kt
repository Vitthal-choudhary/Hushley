package com.example.hushley.Screens

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Icon
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.OutlinedTextField
import androidx.compose.foundation.layout.Box
import androidx.compose.ui.Alignment
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import com.example.hushley.Navigation.Screen
import com.example.hushley.R
import com.example.hushley.ui.theme.AppTypography
import com.example.hushley.ui.theme.primaryContainerLight
import com.example.hushley.ui.theme.primaryLight

@Composable
fun HomeScreen(navController: NavHostController) {
    Scaffold(
        containerColor = primaryLight,
        bottomBar = {
            NavigationBar(
                modifier = Modifier
                    .padding(10.dp)
                    .clip(RoundedCornerShape(20.dp))
                    .fillMaxWidth(), containerColor = primaryContainerLight
            ) {
                NavigationBarItem(
                    icon = { Icon(Icons.Filled.Home, "Home", modifier = Modifier.size(32.dp)) },
                    label = { Text("Home") },
                    selected = navController.currentDestination?.route == Screen.Home.route,
                    onClick = { navController.navigate(Screen.Home.route) })
                NavigationBarItem(
                    icon = {
                        Icon(
                            Icons.Filled.Notifications,
                            "Notifications",
                            modifier = Modifier.size(32.dp)
                        )
                    },
                    label = { Text("Notifications") },
                    selected = navController.currentDestination?.route == Screen.Notification.route,
                    onClick = {
                        navController.navigate(Screen.Notification.route)
                    })
                NavigationBarItem(
                    icon = {
                        Icon(
                            Icons.Filled.Person,
                            "Profile",
                            modifier = Modifier.size(32.dp)
                        )
                    },
                    label = { Text("Profile") },
                    selected = navController.currentDestination?.route == Screen.Profile.route,
                    onClick = {
                        navController.navigate(Screen.Profile.route)
                    })
            }
        },
    ) { paddingValues ->
        Box(modifier = Modifier.padding(paddingValues)) {
            when (navController.currentDestination?.route) {
                Screen.Home.route -> HomeContent()
                Screen.Notification.route -> Notification()
                Screen.Profile.route -> Profile()
                else -> HomeContent()
            }
        }

    }
}

@Composable
fun HomeContent() {
    Column {
        OutlinedTextField(
            value = "",
            onValueChange = { },
            placeholder = { Text("Search") },
            leadingIcon = { Icon(Icons.Default.Search, "Search") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .background(Color.White, RoundedCornerShape(25.dp)),
            shape = RoundedCornerShape(25.dp),
            singleLine = true
        )
        Text(
            "Find Pets",
            modifier = Modifier.padding(16.dp),
            style = AppTypography.headlineLarge
        )
        LazyRow(
            contentPadding = PaddingValues(horizontal = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(6) { index ->
                Card(
                    modifier = Modifier
                        .size(width = 150.dp, height = 200.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(Color.White)
                    ) {

                        val dogImages = listOf(
                            R.drawable.beagle,
                            R.drawable.boxer,
                            R.drawable.bulldog,
                            R.drawable.rottweiler,
                            R.drawable.german_shephard,
                            R.drawable.golden_retriever
                        )
                        Image(
                            painter = painterResource(id = dogImages[index]),

                            contentScale = ContentScale.Crop,
                            contentDescription = "Dog Image",
                            modifier = Modifier
                                .fillMaxSize()
                                .clip(RoundedCornerShape(8.dp))
                        )
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            "Find Shelters",
            modifier = Modifier.padding(16.dp),
            style = AppTypography.headlineLarge,
        )
        LazyRow(
            contentPadding = PaddingValues(horizontal = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(10) { index ->
                Card(
                    modifier = Modifier
                        .size(width = 150.dp, height = 200.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(Color.White)
                    ) {
                        Text(
                            "Card ${index + 1}",
                            modifier = Modifier
                                .padding(16.dp)
                                .align(Alignment.Center)
                        )
                    }
                }
            }
        }
    }
}