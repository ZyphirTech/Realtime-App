package com.zyphir.messaging.realtimeapp.features.auth.data.dto

data class LoginRequest(
    val phone: String,
    val password: String
)

data class RegisterRequest(
    val phone: String,
    val nickname: String,
    val bio: String?,
    val avatarUrl: String?,
    val status: String?,
    val password: String
)

data class RefreshRequest(
    val refreshToken: String
)

