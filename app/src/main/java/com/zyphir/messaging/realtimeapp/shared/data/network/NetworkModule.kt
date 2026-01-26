package com.zyphir.messaging.realtimeapp.shared.data.network

import com.zyphir.messaging.realtimeapp.features.auth.data.network.AuthApiService
import com.zyphir.messaging.realtimeapp.shared.data.interceptors.AuthInterceptor
import com.zyphir.messaging.realtimeapp.shared.manager.TokenManager
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideRetrofitNoAuth(): Retrofit = Retrofit.Builder()
        .baseUrl("https://api.tuapp.com/")
        .addConverterFactory(MoshiConverterFactory.create())
        .build()

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://api.tuapp.com/")
            .addConverterFactory(MoshiConverterFactory.create())
            .client(okHttpClient)
            .build()
    }

    @Provides
    @Singleton
    fun provideOkHttp(
        tokenManager: TokenManager,
        retrofitNoAuth: Retrofit
    ): OkHttpClient {
        val authApi = retrofitNoAuth.create(AuthApiService::class.java)

        return OkHttpClient.Builder()
            .addInterceptor(AuthInterceptor(tokenManager, authApi))
            .build()
    }
}
