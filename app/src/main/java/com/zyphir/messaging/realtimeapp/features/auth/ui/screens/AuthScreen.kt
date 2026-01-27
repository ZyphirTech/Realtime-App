package com.zyphir.messaging.realtimeapp.features.auth.ui.screens

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.NavController
import com.zyphir.messaging.realtimeapp.features.auth.ui.viewmodel.AuthStep
import com.zyphir.messaging.realtimeapp.features.auth.ui.viewmodel.AuthViewModel

@Composable
fun AuthScreen(vm: AuthViewModel, nav: NavController) {
    val state by vm.auth.collectAsState()

    when(val step = state.step) {
        is AuthStep.Phone -> PhoneScreen { vm.onPhoneSubmit(it) }
        is AuthStep.Login -> TODO()
        is AuthStep.Register -> RegisterScreen(step.phone) { n,p -> vm.onRegister(n, p) }
        AuthStep.Loading -> LoadingScreen()
        AuthStep.Error -> TODO()
        AuthStep.Done -> LaunchedEffect(Unit) {
            nav.navigate("chat") { popUpTo("auth") { inclusive = true } }
        }
    }
}