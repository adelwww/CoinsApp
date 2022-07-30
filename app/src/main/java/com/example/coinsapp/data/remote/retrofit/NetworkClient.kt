package com.example.coinsapp.data.remote.retrofit

import com.example.coinsapp.data.remote.apiservices.CoinApiService
import retrofit2.create
import javax.inject.Inject

class NetworkClient @Inject constructor(
    retrofitClient: RetrofitClient,
    okHttp: OkHttp
) {

    private val provideRetrofit = retrofitClient.provideRetrofit(okHttp.provideOkHttpClient())

    fun provideCoinApiService() =provideRetrofit.create(CoinApiService::class.java)

}