package com.zyphir.messaging.realtimeapp.features.auth.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.rememberNavController
import com.zyphir.messaging.realtimeapp.features.auth.ui.screens.AuthScreen
import com.zyphir.messaging.realtimeapp.features.auth.ui.viewmodel.AuthViewModel
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AuthActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            val navController = rememberNavController()
            val vm: AuthViewModel = hiltViewModel()

            AuthScreen(vm = vm, nav = navController)
        }
    }
}