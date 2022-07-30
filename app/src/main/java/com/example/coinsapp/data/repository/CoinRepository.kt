package com.example.coinsapp.data.repository

import com.example.coinsapp.data.remote.apiservices.CoinApiService
import com.example.coinsapp.data.repository.base.BaseRepository
import javax.inject.Inject

class CoinRepository @Inject constructor(
    private val apiService: CoinApiService
) : BaseRepository() {

    fun fetchCoins() = doRequest {
        apiService.fetchCoins()
    }
}