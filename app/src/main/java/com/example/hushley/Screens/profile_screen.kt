package com.example.hushley.Screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.hushley.R
import com.example.hushley.ui.theme.*

@Composable
fun Profile(navController: NavHostController) {
    Scaffold(
        bottomBar = {
            BottomNavigationBar(navController)
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(secondaryContainerDarkMediumContrast)
                .padding(paddingValues)
        ) {
            LazyColumn(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxSize()
            ) {
                item {
                    Image(
                        painter = painterResource(id = R.drawable.logo),
                        contentDescription = "Profile Picture",
                        modifier = Modifier
                            .size(300.dp)
                            .clip(CircleShape)
                    )
                }
                item {
                    ProfileCard("Name:", "User Name")
                }
                item {
                    ProfileCard("Age:", "20")
                }
                item {
                    ProfileCard("Sex:", "Male")
                }
                item {
                    ProfileCard("Phone:", "+91 9999999999")
                }
                item {
                    ProfileCard("Mail:", "abc@gmail.com")
                }
                item {
                    ProfileCard("Address:", "India")
                }
            }
        }
    }
}

@Composable
fun ProfileCard(label: String, value: String) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        border = BorderStroke(1.dp, color = primaryDark),
        colors = CardDefaults.cardColors(containerColor = secondaryDark)
    ) {
        Row(modifier = Modifier.padding(16.dp)) {
            Text(text = "$label", fontWeight = FontWeight.Bold, fontSize = 18.sp, color = scrimLightHighContrast)
            Text(text = " $value", fontSize = 18.sp, color = scrimLightHighContrast)
        }
    }
}