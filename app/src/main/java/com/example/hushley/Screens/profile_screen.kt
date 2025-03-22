package com.example.hushley.Screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ExitToApp
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Edit
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.hushley.R
import com.example.hushley.ui.theme.*

@Composable
fun Profile(navController: NavHostController) {
    // State to hold user details
    var userDetails by remember {
        mutableStateOf(
            mapOf(
                "Name" to "User Name",
                "Age" to "20",
                "Sex" to "Male",
                "Phone" to "+91 9999999999",
                "Mail" to "abc@gmail.com",
                "Address" to "India"
            )
        )
    }

    // State to control edit dialog visibility
    var showEditDialog by remember { mutableStateOf(false) }

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
                    Text(
                        text = "@User",
                        style = MaterialTheme.typography.headlineLarge,
                        textAlign = TextAlign.Center,
                        color = primaryDarkMediumContrast
                    )
                }
                item {
                    ProfileCard(details = userDetails)
                }
                item {
                    Button(
                        onClick = { showEditDialog = true },
                        modifier = Modifier
                            .fillMaxWidth(0.5f)
                            .padding(10.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Filled.Edit,
                            contentDescription = "Edit",
                            modifier = Modifier.padding(end = 5.dp)
                        )
                        Text(
                            text = "Edit Details"
                        )
                    }
                }
                item {
                    Button(
                        onClick = {},
                        modifier = Modifier
                            .fillMaxWidth(0.5f)
                            .padding(10.dp)
                    ) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ExitToApp,
                            contentDescription = "Log out",
                            modifier = Modifier.padding(end = 5.dp)
                        )
                        Text(
                            text = "Log Out"
                        )
                    }
                }
            }
        }

        // Edit Profile Dialog
        if (showEditDialog) {
            EditProfileDialog(
                initialDetails = userDetails,
                onSave = { newDetails ->
                    userDetails = newDetails
                    showEditDialog = false
                },
                onDismiss = { showEditDialog = false }
            )
        }
    }
}

@Composable
fun ProfileCard(details: Map<String, String>) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .border(1.dp, primaryDark, RoundedCornerShape(16.dp)),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = secondaryDark)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            details.forEach { (label, value) ->
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(vertical = 8.dp)
                ) {
                    Text(
                        text = "$label:",
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp,
                        color = scrimLightHighContrast,
                        modifier = Modifier.weight(1f)
                    )
                    Text(
                        text = value,
                        fontSize = 18.sp,
                        color = scrimLightHighContrast,
                        modifier = Modifier.weight(1f)
                    )
                }
            }
        }
    }
}

@Composable
fun EditProfileDialog(
    initialDetails: Map<String, String>,
    onSave: (Map<String, String>) -> Unit,
    onDismiss: () -> Unit
) {
    // Create mutable state for each field
    val editableDetails = remember {
        initialDetails.mapValues { (_, value) -> mutableStateOf(value) }
    }

    Dialog(onDismissRequest = onDismiss) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            shape = RoundedCornerShape(16.dp),
            colors = CardDefaults.cardColors(containerColor = secondaryDark)
        ) {
            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
            ) {
                // Title
                Text(
                    text = "Edit Profile",
                    fontWeight = FontWeight.Bold,
                    fontSize = 22.sp,
                    color = scrimLightHighContrast,
                    modifier = Modifier
                        .padding(bottom = 16.dp)
                        .align(Alignment.CenterHorizontally)
                )

                // Edit fields
                editableDetails.forEach { (key, stateValue) ->
                    val keyboardType = when (key) {
                        "Age" -> KeyboardType.Number
                        "Phone" -> KeyboardType.Phone
                        "Mail" -> KeyboardType.Email
                        else -> KeyboardType.Text
                    }

                    OutlinedTextField(
                        value = stateValue.value,
                        onValueChange = { stateValue.value = it },
                        label = { Text(key) },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp),
                        keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedTextColor = scrimLightHighContrast,
                            unfocusedTextColor = scrimLightHighContrast,
                            focusedBorderColor = primaryDarkMediumContrast,
                            unfocusedBorderColor = primaryDark,
                            focusedLabelColor = primaryDarkMediumContrast,
                            unfocusedLabelColor = scrimLightHighContrast
                        )
                    )
                }

                // Buttons
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 16.dp),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    Button(
                        onClick = onDismiss,
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color.Gray
                        )
                    ) {
                        Icon(
                            imageVector = Icons.Default.Close,
                            contentDescription = "Cancel",
                            modifier = Modifier.padding(end = 4.dp)
                        )
                        Text("Cancel")
                    }

                    Button(
                        onClick = {
                            // Convert the mutable state values back to a regular map
                            val updatedDetails =
                                editableDetails.mapValues { (_, state) -> state.value }
                            onSave(updatedDetails)
                        }
                    ) {
                        Icon(
                            imageVector = Icons.Default.Check,
                            contentDescription = "Save",
                            modifier = Modifier.padding(end = 4.dp)
                        )
                        Text("Save")
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun ProfilePreview() {
    val navController = rememberNavController()
    Profile(navController = navController)
}