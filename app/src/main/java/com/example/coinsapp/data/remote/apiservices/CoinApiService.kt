package com.example.coinsapp.data.remote.apiservices

import com.example.coinsapp.data.models.CoinModel
import retrofit2.http.GET

interface CoinApiService {

    @GET("coins")
    suspend fun fetchCoins(): List<CoinModel>
}