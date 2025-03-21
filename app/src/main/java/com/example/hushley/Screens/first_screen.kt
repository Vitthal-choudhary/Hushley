package com.example.hushley.Screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.material3.Button
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import com.example.hushley.ui.theme.primaryLight
import androidx.compose.ui.res.painterResource
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Phone
import androidx.compose.ui.unit.dp
import com.example.hushley.R
import androidx.navigation.NavHostController
import com.example.hushley.Navigation.Screen
import com.example.hushley.ui.theme.AppTypography

@Composable
fun Launch(navController: NavHostController) {
    Scaffold { paddingValues ->
        Column(
            modifier = Modifier
                .background(primaryLight)
                .fillMaxSize()
                .padding(paddingValues),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "Round Image",
                modifier = Modifier
                    .size(350.dp)
                    .padding(16.dp)
                    .clip(CircleShape)
            )
            Spacer(modifier = Modifier.height(32.dp))

            Button(
                onClick = {
                    navController.navigate(Screen.Home.route){
                        popUpTo(Screen.Launch.route) {
                            inclusive = true
                        }
                    }
                },
                modifier = Modifier
                    .requiredHeight(56.dp)
                    .requiredWidth(400.dp)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Icon(
                        imageVector = Icons.Filled.Email,
                        contentDescription = "Email Logo",
                        modifier = Modifier.size(30.dp)
                    )
                    Text(
                        text = "Login with Email",
                        style = AppTypography.headlineLarge,
                        modifier = Modifier.padding(start = 8.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.height(32.dp))
            Button(
                onClick = {
                    navController.navigate(Screen.Home.route){
                        popUpTo(Screen.Launch.route) {
                            inclusive = true
                        }
                    }
                },
                modifier = Modifier
                    .requiredHeight(56.dp)
                    .requiredWidth(400.dp)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Icon(
                        imageVector = Icons.Filled.Phone,
                        contentDescription = "Phone Logo",
                        modifier = Modifier.size(30.dp)
                    )
                    Text(
                        text = "Login with Phone",
                        style = AppTypography.headlineLarge,
                        modifier = Modifier.padding(start = 8.dp)
                    )
                }
            }
        }
    }
}