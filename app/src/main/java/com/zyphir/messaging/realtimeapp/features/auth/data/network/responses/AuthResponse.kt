package com.zyphir.messaging.realtimeapp.features.auth.data.network.responses

import com.squareup.moshi.JsonClass
import com.zyphir.messaging.realtimeapp.features.auth.domain.model.RegisterModel

@JsonClass(generateAdapter = true)
data class AuthResponse(
    val accessToken: String,
    val refreshToken: String
) {
    fun toDomain(): RegisterModel {
        return RegisterModel(
            accessToken = accessToken,
            refreshToken = refreshToken
        )
    }
}
