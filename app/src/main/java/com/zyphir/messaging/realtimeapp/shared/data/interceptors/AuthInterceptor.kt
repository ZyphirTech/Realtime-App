package com.zyphir.messaging.realtimeapp.shared.data.interceptors

import com.zyphir.messaging.realtimeapp.features.auth.data.network.AuthApiService
import com.zyphir.messaging.realtimeapp.shared.manager.TokenManager
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class AuthInterceptor @Inject constructor(private val tokenManager: TokenManager, private val api: AuthApiService) :
    Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val token = runBlocking { tokenManager.accessToken.first() }

        val req = chain.request().newBuilder().addHeader("Authorization", "Bearer $token").build()
        val res = chain.proceed(req)

        if(res.code == 401) {
            val refresh = runBlocking { tokenManager.refreshToken.first() }


        }

        TODO("Not yet implemented")
    }
}