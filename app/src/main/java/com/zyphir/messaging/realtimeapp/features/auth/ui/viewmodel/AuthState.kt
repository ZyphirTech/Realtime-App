package com.zyphir.messaging.realtimeapp.features.auth.ui.viewmodel

data class AuthState (
    val step: AuthStep = AuthStep.Phone,
    val phone: String = "",
    val nickname: String = "",
    val bio: String? = "",
    val avatarUrl: String? = "",
    val status: String? = "",
    val password: String = "",
    val error: String? = null
)