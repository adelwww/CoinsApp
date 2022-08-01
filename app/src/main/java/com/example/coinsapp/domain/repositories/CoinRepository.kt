package com.example.coinsapp.domain.repositories

import com.example.coinsapp.domain.model.CoinModel
import com.example.coinsapp.domain.either.Either
import kotlinx.coroutines.flow.Flow

interface CoinRepository {

    fun fetchCoins() : Flow<Either<String, List<CoinModel>>>
}