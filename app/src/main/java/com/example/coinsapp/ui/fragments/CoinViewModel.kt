package com.example.coinsapp.ui.fragments

import com.example.coinsapp.base.BaseViewModel
import com.example.coinsapp.data.repository.CoinRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CoinViewModel @Inject constructor(
    private val repository: CoinRepository
) : BaseViewModel() {

    fun fetchCoins() = repository.fetchCoins()
}