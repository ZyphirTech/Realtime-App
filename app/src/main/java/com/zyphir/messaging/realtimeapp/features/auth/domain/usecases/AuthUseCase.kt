package com.zyphir.messaging.realtimeapp.features.auth.domain.usecases

import com.zyphir.messaging.realtimeapp.features.auth.data.dto.RegisterRequest
import com.zyphir.messaging.realtimeapp.features.auth.domain.repository.AuthRepository
import javax.inject.Inject

class AuthUseCase @Inject constructor(private val repository: AuthRepository) {
    suspend fun register(request: RegisterRequest) = repository.registerUser(request)
}