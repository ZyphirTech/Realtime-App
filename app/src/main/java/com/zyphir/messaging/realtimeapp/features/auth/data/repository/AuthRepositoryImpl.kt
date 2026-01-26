package com.zyphir.messaging.realtimeapp.features.auth.data.repository

import android.util.Log
import com.zyphir.messaging.realtimeapp.features.auth.data.dto.RegisterRequest
import com.zyphir.messaging.realtimeapp.features.auth.data.network.AuthApiService
import com.zyphir.messaging.realtimeapp.features.auth.domain.model.RegisterModel
import com.zyphir.messaging.realtimeapp.features.auth.domain.repository.AuthRepository
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(private val apiService: AuthApiService) : AuthRepository {

    override suspend fun registerUser(request: RegisterRequest): RegisterModel? {
        runCatching { apiService.register(request) }
            .onSuccess { return it.toDomain() }
            .onFailure { Log.i("Register", "Ha ocurrido un error ${it.message}") }

        return null
    }

}