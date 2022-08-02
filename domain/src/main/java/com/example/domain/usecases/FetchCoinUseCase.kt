package com.example.domain.usecases

import com.example.domain.repositories.CoinRepository
import javax.inject.Inject

class FetchCoinUseCase @Inject constructor(
    private val repository: CoinRepository
) {

    operator fun invoke() = repository.fetchCoins()

}