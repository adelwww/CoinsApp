package com.example.domain.repositories

import com.example.domain.models.CoinModel
import com.example.domain.either.Either
import kotlinx.coroutines.flow.Flow

interface CoinRepository {

    fun fetchCoins() : Flow<Either<String, List<CoinModel>>>
}