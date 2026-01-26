package com.zyphir.messaging.realtimeapp.features.auth.data.network

import com.zyphir.messaging.realtimeapp.features.auth.data.dto.RegisterRequest
import com.zyphir.messaging.realtimeapp.features.auth.data.network.responses.AuthResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthApiService {
    @POST("/auth/register")
    suspend fun register(@Body request: RegisterRequest) : AuthResponse
}