package com.zyphir.messaging.realtimeapp.shared.ui.nav

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.zyphir.messaging.realtimeapp.features.chat.ui.screens.ChatScreen

@Composable
fun AppNav() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "home"
    ) {
        composable("chat") { ChatScreen() }
        composable("chat/{id}") {  }
    }
}