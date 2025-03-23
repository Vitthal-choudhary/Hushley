package com.example.hushley.Screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.hushley.R

@Composable
fun DogInfoScreen(navController: NavHostController, petId: Int, name: String, speciesId: Int, age: String, gender: String, size: String, description: String, shelterId: Int, medicalRecord: String, imageRes: Int) {
    Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(240.dp)
        ) {
            Image(
                painter = painterResource(id = imageRes),
                contentDescription = name,
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
                    text = "Pet ID: $petId",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color.Gray
                )
                Text(
                    text = "Name: $name",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(top = 8.dp, bottom = 4.dp)
                )
                Text(
                    text = "Species ID: $speciesId",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color.Gray
                )
                Text(
                    text = "Age: $age",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color.Gray
                )
                Text(
                    text = "Gender: $gender",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color.Gray
                )
                Text(
                    text = "Size: $size",
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
                Text(
                    text = "Shelter ID: $shelterId",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color.Gray
                )
                Text(
                    text = "Medical Record: $medicalRecord",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color.Gray,
                    modifier = Modifier.padding(bottom = 16.dp)
                )
                Button(
                    onClick = { /* Handle adoption request */ },
                    modifier = Modifier.fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFE91E63)),
                    shape = RoundedCornerShape(8.dp)
                ) {
                    Text(
                        text = "REQUEST ADOPTION",
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
fun Dog1Screen(navController: NavHostController) {
    DogInfoScreen(
        navController = navController,
        petId = 12345,
        name = "Beagle",
        speciesId = 67890,
        age = "3 years",
        gender = "Male",
        size = "Medium",
        description = "Friendly and energetic 3-year-old Beagle. Great with kids, other pets, and loves outdoor activities. Fully vaccinated and trained.",
        shelterId = 54321,
        medicalRecord = "Fully vaccinated and healthy.",
        imageRes = R.drawable.beagle
    )
}

@Composable
fun Dog2Screen(navController: NavHostController) {
    DogInfoScreen(
        navController = navController,
        petId = 23456,
        name = "Max",
        speciesId = 78901,
        age = "4 years",
        gender = "Male",
        size = "Large",
        description = "Loyal and intelligent German Shepherd. Well-trained and protective. Excellent guard dog with a gentle nature towards family members.",
        shelterId = 65432,
        medicalRecord = "All vaccinations up to date, regular check-ups done.",
        imageRes = R.drawable.boxer
    )
}

@Composable
fun Dog3Screen(navController: NavHostController) {
    DogInfoScreen(
        navController = navController,
        petId = 34567,
        name = "Luna",
        speciesId = 89012,
        age = "2 years",
        gender = "Female",
        size = "Large",
        description = "Friendly and gentle Golden Retriever. Great with children and other pets. Loves swimming and playing fetch.",
        shelterId = 76543,
        medicalRecord = "Healthy, spayed, and all vaccinations current.",
        imageRes = R.drawable.bulldog
    )
}

@Composable
fun Dog4Screen(navController: NavHostController) {
    DogInfoScreen(
        navController = navController,
        petId = 45678,
        name = "Storm",
        speciesId = 90123,
        age = "1.5 years",
        gender = "Male",
        size = "Large",
        description = "Energetic and playful Husky. Needs active family, loves running and outdoor adventures. Good with experienced dog owners.",
        shelterId = 87654,
        medicalRecord = "Regular check-ups done, all vaccinations complete.",
        imageRes = R.drawable.rottweiler
    )
}

@Composable
fun Dog5Screen(navController: NavHostController) {
    DogInfoScreen(
        navController = navController,
        petId = 56789,
        name = "Charlie",
        speciesId = 1234,
        age = "2.5 years",
        gender = "Male",
        size = "Large",
        description = "Sweet and gentle Labrador Retriever. Excellent family dog, great with kids. Loves water and playing fetch.",
        shelterId = 98765,
        medicalRecord = "Fully vaccinated, neutered, and in excellent health.",
        imageRes = R.drawable.german_shephard
    )
}

@Composable
fun Dog6Screen(navController: NavHostController) {
    DogInfoScreen(
        navController = navController,
        petId = 67890,
        name = "Bella",
        speciesId = 12345,
        age = "1 year",
        gender = "Female",
        size = "Small",
        description = "Adorable and affectionate Pug. Perfect for apartment living. Loves cuddles and short walks.",
        shelterId = 9876,
        medicalRecord = "All vaccinations complete, regular vet check-ups done.",
        imageRes = R.drawable.golden_retriever
    )
}