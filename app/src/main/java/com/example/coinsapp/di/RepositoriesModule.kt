package com.example.coinsapp.di

import com.example.data.repository.CoinRepositoryImpl
import com.example.domain.repositories.CoinRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoriesModule {

    @Binds
    abstract fun provideCoinRepository(repositoryImpl: CoinRepositoryImpl): CoinRepository
}

