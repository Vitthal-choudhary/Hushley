package com.example.hushley.Screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.hushley.ui.theme.inversePrimaryLight
import com.example.hushley.ui.theme.tertiaryContainerDark
import com.example.hushley.ui.theme.tertiaryDark

@Composable
fun Notification(navController: NavHostController) {
    Scaffold(
        bottomBar = {
            BottomNavigationBar(navController)
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .background(inversePrimaryLight)
                .fillMaxSize()
                .padding(paddingValues),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            val notifications = listOf(
                NotificationData("New Message", "You have a new message from John Doe.", Icons.Filled.Notifications),
                NotificationData("Reminder", "Don't forget your meeting at 2 PM.", Icons.Filled.Notifications),
                NotificationData("Update Available", "A new app update is ready to install.", Icons.Filled.Notifications)
            )

            LazyColumn {
                items(notifications) { notification ->
                    NotificationCard(notification)
                    Spacer(modifier = Modifier.padding(8.dp))
                }
            }
        }
    }
}

data class NotificationData(val heading: String, val body: String, val icon: androidx.compose.ui.graphics.vector.ImageVector)

@Composable
fun NotificationCard(notification: NotificationData) {
    var isExpanded by remember { mutableStateOf(false) }
    var isRead by remember { mutableStateOf(false) }

    val backgroundColor = when {
        isRead -> tertiaryDark
        isExpanded -> tertiaryDark
        else -> tertiaryContainerDark
    }
    val cardModifier = if (!isRead) Modifier
        .fillMaxWidth()
        .clickable { isExpanded = true; isRead = true }
    else Modifier.fillMaxWidth()
    Card(
        modifier = cardModifier,
        elevation = CardDefaults.cardElevation(defaultElevation = if (isExpanded) 0.dp else 4.dp),
        colors = CardDefaults.cardColors(containerColor = backgroundColor)
    ) {
        Row(modifier = Modifier.padding(16.dp), verticalAlignment = Alignment.CenterVertically) {
            Icon(imageVector = notification.icon, contentDescription = "Notification Icon")
            Spacer(modifier = Modifier.padding(8.dp))
            Column {
                Text(text = notification.heading, fontWeight = FontWeight.Bold)
                if (isExpanded) {
                    Text(text = notification.body)
                }
            }
        }
    }
}