package com.example.data.repositories

import com.example.data.remote.dtos.toDomain
import com.example.data.remote.apiservices.CoinApiService
import com.example.data.repositories.base.BaseRepository
import com.example.domain.either.Either
import com.example.domain.repositories.CoinRepository
import com.example.domain.models.CoinModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val apiService: CoinApiService
) : BaseRepository(), CoinRepository {

    override fun fetchCoins(): Flow<Either<String, List<CoinModel>>> = doRequest {
       apiService.fetchCoins().map { it.toDomain() }
    }


}