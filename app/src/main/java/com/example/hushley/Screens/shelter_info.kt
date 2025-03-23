package com.example.hushley.Screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.tooling.preview.Preview

import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.hushley.R

@Composable
fun ShelterInfoScreen(
    navController: NavHostController,
    shelterId: Int,
    shelterName: String,
    location: String,
    description: String,
    imageRes: Int
) {
    Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(240.dp)
        ) {
            Image(
                painter = painterResource(id = imageRes),
                contentDescription = "Shelter Image",
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )
        }
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
                .offset(y = (-20).dp),
            shape = RoundedCornerShape(12.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White)
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text(
                    text = "Shelter ID: $shelterId",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color.Gray
                )
                Text(
                    text = "Shelter Name: $shelterName",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(top = 8.dp, bottom = 4.dp)
                )
                Text(
                    text = "Location: $location",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color.Gray
                )
                Text(
                    text = "Description: $description",
                    fontSize = 14.sp,
                    color = Color.Gray,
                    modifier = Modifier.padding(vertical = 8.dp)
                )
                Button(
                    onClick = { /* Handle contact shelter */ },
                    modifier = Modifier.fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFE91E63)),
                    shape = RoundedCornerShape(8.dp)
                ) {
                    Text(
                        text = "CONTACT SHELTER",
                        fontWeight = FontWeight.Bold,
                        fontSize = 14.sp,
                        modifier = Modifier.padding(vertical = 4.dp)
                    )
                }
            }
        }
    }
}

@Composable
fun Shelter1Screen(navController: NavHostController) {
    ShelterInfoScreen(
        navController,
        shelterId = 1,
        shelterName = "Aiken Shelter",
        location = "Aiken, SC",
        description = "Aiken Shelter provides a safe haven for animals in need.",
        imageRes = R.drawable.aiken
    )
}

@Composable
fun Shelter2Screen(navController: NavHostController) {
    ShelterInfoScreen(
        navController,
        shelterId = 2,
        shelterName = "Cheyenne Shelter",
        location = "Cheyenne, WY",
        description = "Cheyenne Shelter offers adoption services and animal care.",
        imageRes = R.drawable.cheyenne
    )
}

@Composable
fun Shelter3Screen(navController: NavHostController) {
    ShelterInfoScreen(
        navController,
        shelterId = 3,
        shelterName = "Jackson Shelter",
        location = "Jackson, MS",
        description = "Jackson Shelter is dedicated to rescuing and rehabilitating animals.",
        imageRes = R.drawable.jackson
    )
}

@Composable
fun Shelter4Screen(navController: NavHostController) {
    ShelterInfoScreen(
        navController,
        shelterId = 4,
        shelterName = "Laramie Shelter",
        location = "Laramie, WY",
        description = "Laramie Shelter provides medical care and adoption services.",
        imageRes = R.drawable.laramie
    )
}

@Composable
fun Shelter5Screen(navController: NavHostController) {
    ShelterInfoScreen(
        navController,
        shelterId = 5,
        shelterName = "Newberg Shelter",
        location = "Newberg, OR",
        description = "Newberg Shelter focuses on animal welfare and community education.",
        imageRes = R.drawable.newberg
    )
}

@Composable
fun Shelter6Screen(navController: NavHostController) {
    ShelterInfoScreen(
        navController,
        shelterId = 6,
        shelterName = "Susquehanna Shelter",
        location = "Susquehanna, PA",
        description = "Susquehanna Shelter offers a variety of animal services.",
        imageRes = R.drawable.susquehanna
    )
}