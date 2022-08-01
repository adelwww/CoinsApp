package com.example.data.remote.apiservices

import com.example.data.dtos.CoinDto
import retrofit2.http.GET

interface CoinApiService {

    @GET("coins")
    suspend fun fetchCoins(): List<CoinDto>
}