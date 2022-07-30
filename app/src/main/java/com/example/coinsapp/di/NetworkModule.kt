package com.example.coinsapp.di

import com.example.coinsapp.data.remote.retrofit.NetworkClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule{

    @Singleton
    @Provides
    fun provideCoinApiService(
        networkClient: NetworkClient
    ) = networkClient.provideCoinApiService()
}