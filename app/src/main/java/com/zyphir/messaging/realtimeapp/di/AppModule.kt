package com.zyphir.messaging.realtimeapp.di

import com.zyphir.messaging.realtimeapp.features.auth.data.repository.AuthRepositoryImpl
import com.zyphir.messaging.realtimeapp.features.auth.domain.repository.AuthRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class AppModule {

    @Binds
    @Singleton
    abstract fun bindAuthRepository(
        authRepositoryImpl: AuthRepositoryImpl
    ): AuthRepository
}