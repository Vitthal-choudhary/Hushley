package com.example.hushley.Screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.hushley.Navigation.Screen;
import com.example.hushley.R
import com.example.hushley.ui.theme.AppTypography
import com.example.hushley.ui.theme.primaryLight

@Composable
fun HomeScreen(navController: NavHostController) {
    Scaffold(
        bottomBar = {
            BottomNavigationBar(navController)
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(primaryLight)
                .padding(paddingValues)
        ) {
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
                            .clickable{
                                when (index) {
                                    0 -> navController.navigate(Screen.Dog1.route)
                                    1 -> navController.navigate(Screen.Dog2.route)
                                    2 -> navController.navigate(Screen.Dog3.route)
                                    3 -> navController.navigate(Screen.Dog4.route)
                                    4 -> navController.navigate(Screen.Dog5.route)
                                    5 -> navController.navigate(Screen.Dog6.route)
                                }
                            }
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
                            val shelterImages = listOf(
                                R.drawable.aiken,
                                R.drawable.cheyenne,
                                R.drawable.jackson,
                                R.drawable.laramie,
                                R.drawable.newberg,
                                R.drawable.susquehanna
                            )
                            Image(
                                painter = painterResource(id = shelterImages[index]),

                                contentScale = ContentScale.Crop,
                                contentDescription = "Shelter Image",
                                modifier = Modifier
                                    .fillMaxSize()
                                    .clip(RoundedCornerShape(8.dp))
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun BottomNavigationBar(navController: NavHostController) {
    BottomAppBar(
        containerColor = MaterialTheme.colorScheme.primary

    ) {
        NavigationBarItem(
            icon = {
                Icon(
                    imageVector = Icons.Filled.Home,
                    contentDescription = "Home"
                )
            },
            selected = false,
            onClick = {
                navController.navigate(Screen.Home.route) {
                    popUpTo(Screen.Home.route) { inclusive = true }
                }
            }
        )
        NavigationBarItem(
            icon = {
                Icon(
                    imageVector = Icons.Filled.Notifications,
                    contentDescription = "Notifications"
                )
            },
            selected = false,
            onClick = {
                navController.navigate(Screen.Notification.route) {
                    popUpTo(Screen.Home.route) { inclusive = false }
                }
            }
        )
        NavigationBarItem(
            icon = {
                Icon(
                    imageVector = Icons.Filled.Person,
                    contentDescription = "Profile"
                )
            },
            selected = false,
            onClick = {
                navController.navigate(Screen.Profile.route) {
                    popUpTo(Screen.Home.route) { inclusive = false }
                }
            }
        )
    }
}
