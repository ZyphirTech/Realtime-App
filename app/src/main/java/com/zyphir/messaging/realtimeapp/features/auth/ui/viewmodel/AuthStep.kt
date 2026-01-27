package com.zyphir.messaging.realtimeapp.features.auth.ui.viewmodel

sealed class AuthStep {
    object Phone : AuthStep()
    data class Login(val phone: String) : AuthStep()
    data class Register(val phone: String) : AuthStep()
    object Loading : AuthStep()
    object Error : AuthStep()
    object Done : AuthStep()
}
