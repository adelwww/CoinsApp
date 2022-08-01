package com.example.coinsapp.domain.usecase

import com.example.coinsapp.domain.repositories.CoinRepository
import javax.inject.Inject

class CoinUseCase @Inject constructor(
    private val repository: CoinRepository
) {

    operator fun invoke() = repository.fetchCoins()

}