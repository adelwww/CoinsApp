package com.example.coinsapp.data.repository

import com.example.coinsapp.data.dtos.toDomain
import com.example.coinsapp.data.remote.apiservices.CoinApiService
import com.example.coinsapp.data.repository.base.BaseRepository
import com.example.coinsapp.domain.either.Either
import com.example.coinsapp.domain.model.CoinModel
import com.example.coinsapp.domain.repositories.CoinRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val apiService: CoinApiService
) : BaseRepository(), CoinRepository {

    override fun fetchCoins(): Flow<Either<String, List<CoinModel>>> = doRequest {
       apiService.fetchCoins().map { it.toDomain() }
    }


}