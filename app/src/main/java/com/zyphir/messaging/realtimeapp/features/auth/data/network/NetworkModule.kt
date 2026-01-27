package com.zyphir.messaging.realtimeapp.features.auth.data.network

import com.zyphir.messaging.realtimeapp.shared.data.qualifiers.NoAuth
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideAuthApi(
        @NoAuth retrofit: Retrofit
    ): AuthApiService = retrofit.create(AuthApiService::class.java)
}