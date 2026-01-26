package com.zyphir.messaging.realtimeapp.features.auth.domain.repository

import com.zyphir.messaging.realtimeapp.features.auth.data.dto.RegisterRequest
import com.zyphir.messaging.realtimeapp.features.auth.domain.model.RegisterModel

interface AuthRepository {
    suspend fun registerUser(request: RegisterRequest): RegisterModel?
}