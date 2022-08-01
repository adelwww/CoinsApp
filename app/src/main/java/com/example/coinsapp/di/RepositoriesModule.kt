package com.example.coinsapp.di

import com.example.coinsapp.data.repository.CoinRepositoryImpl
import com.example.coinsapp.domain.repositories.CoinRepository
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
