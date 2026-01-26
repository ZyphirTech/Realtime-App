package com.zyphir.messaging.realtimeapp.features.auth.data.network

import com.zyphir.messaging.realtimeapp.features.auth.data.repository.AuthRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    @Provides
    fun provideAuthApi(retrofit: Retrofit): AuthApiService {
        return retrofit.create(AuthApiService::class.java)
    }

    @Provides
    fun provideRepository(apiService: AuthApiService): AuthRepositoryImpl {
        return AuthRepositoryImpl(apiService)
    }
}