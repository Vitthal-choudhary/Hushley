package com.example.hushley.Screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.hushley.R
import com.example.hushley.ui.theme.onSecondaryContainerDark
import com.example.hushley.ui.theme.primaryDark
import com.example.hushley.ui.theme.scrimLightHighContrast
import com.example.hushley.ui.theme.secondaryContainerDarkMediumContrast
import com.example.hushley.ui.theme.secondaryDark

@Composable
fun Profile(){
    Column (
        modifier = Modifier.fillMaxSize().background(secondaryContainerDarkMediumContrast)
    ) {
        LazyColumn(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center, modifier = Modifier.fillMaxSize()) {
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
                Card(
                    modifier = Modifier
                        .padding(8.dp)
                        .fillMaxWidth(),
                    shape = RoundedCornerShape(16.dp),
                    border = BorderStroke(1.dp, color = primaryDark),
                    colors = CardDefaults.cardColors(
                        containerColor = secondaryDark
                    )
                ) {
                    Row(modifier = Modifier.padding(16.dp)) {
                        Text(
                            text = "Name:",
                            fontWeight = FontWeight.Bold,
                            fontSize = 18.sp,
                            color = scrimLightHighContrast
                        )
                        Text(text = " User Name", fontSize = 18.sp, color = scrimLightHighContrast)
                    }
                }
            }
            item {
                Card(
                    modifier = Modifier
                        .padding(8.dp)
                        .fillMaxWidth(),
                    shape = RoundedCornerShape(16.dp),
                    border = BorderStroke(1.dp, color = primaryDark),
                    colors = CardDefaults.cardColors(
                        containerColor = secondaryDark
                    )
                ) {
                    Row(modifier = Modifier.padding(16.dp)) {
                        Text(text = "Age:", fontWeight = FontWeight.Bold, fontSize = 18.sp, color = scrimLightHighContrast)
                        Text(text = " 20", fontSize = 18.sp, color = scrimLightHighContrast)
                    }
                }
            }
            item {
                Card(
                    modifier = Modifier
                        .padding(8.dp)
                        .fillMaxWidth(),
                    shape = RoundedCornerShape(16.dp),
                    border = BorderStroke(1.dp, color = primaryDark),
                    colors = CardDefaults.cardColors(
                        containerColor = secondaryDark
                    )
                ) {
                    Row(modifier = Modifier.padding(16.dp)) {
                        Text(text = "Sex:", fontWeight = FontWeight.Bold, fontSize = 18.sp, color = scrimLightHighContrast)
                        Text(text = " Male", fontSize = 18.sp, color = scrimLightHighContrast)
                    }
                }
            }
            item {
                Card(
                    modifier = Modifier
                        .padding(8.dp)
                        .fillMaxWidth(),
                    shape = RoundedCornerShape(16.dp),
                    border = BorderStroke(1.dp, color = primaryDark),
                    colors = CardDefaults.cardColors(
                        containerColor = secondaryDark
                    )
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Row{
                            Text(text = "Phone:", fontWeight = FontWeight.Bold, fontSize = 18.sp, color = scrimLightHighContrast)
                            Text(text = " +91 9999999999", fontSize = 18.sp, color = scrimLightHighContrast)
                        }
                        Row{
                            Text(text = "Mail:", fontWeight = FontWeight.Bold, fontSize = 18.sp, color = scrimLightHighContrast)
                            Text(text = " abc@gmail.com", fontSize = 18.sp, color = scrimLightHighContrast)
                        }
                        Row{
                            Text(text = "Address:", fontWeight = FontWeight.Bold, fontSize = 18.sp, color = scrimLightHighContrast)
                            Text(text = " India", fontSize = 18.sp, color = scrimLightHighContrast)
                        }
                    }
                }
            }

        }
    }
}

@Preview
@Composable
fun ProfilePreview(){
    Profile()
}
