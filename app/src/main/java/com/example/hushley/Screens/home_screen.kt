package com.example.hushley.Screens

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
import androidx.compose.material3.MaterialTheme
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.hushley.R
import com.example.hushley.ui.theme.AppTypography
import com.example.hushley.ui.theme.primaryContainerLight
import com.example.hushley.ui.theme.primaryLight

@Composable
fun HomeScreen() {
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
                    selected = true,
                    onClick = { /*TODO*/ })
                NavigationBarItem(
                    icon = {
                        Icon(
                            Icons.Filled.Notifications,
                            "Notifications",
                            modifier = Modifier.size(32.dp)
                        )
                    },
                    label = { Text("Notifications") },
                    selected = false, onClick = { /*TODO*/ })
                NavigationBarItem(
                    icon = {
                        Icon(
                            Icons.Filled.Person,
                            "Profile",
                            modifier = Modifier.size(32.dp)
                        )
                    },
                    label = { Text("Profile") },
                    selected = false, onClick = { /*TODO*/ })
            }
        },
    ) {
        Column(
            modifier = Modifier
                .padding(it)
                .background(primaryLight)
                .fillMaxSize()
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
                items(6) { index -> // Set number of cards to 6
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
}

@Preview
@Composable
fun PreviewHomeScreen() {
    HomeScreen()
}
