package com.example.coinsapp.data.remote.apiservices

import com.example.coinsapp.data.dtos.CoinDto
import retrofit2.http.GET

interface CoinApiService {

    @GET("coins")
    suspend fun fetchCoins(): List<CoinDto>
}