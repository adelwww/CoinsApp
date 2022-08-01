package com.example.data.remote.retrofit

import com.example.data.remote.apiservices.CoinApiService
import javax.inject.Inject

class NetworkClient @Inject constructor(
    retrofitClient: RetrofitClient,
    okHttp: OkHttp
) {

    private val provideRetrofit = retrofitClient.provideRetrofit(okHttp.provideOkHttpClient())

    fun provideCoinApiService() =provideRetrofit.create(CoinApiService::class.java)

}