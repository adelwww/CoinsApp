package com.example.coinsapp.presentation.ui.fragments

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.coinsapp.presentation.ui.base.BaseViewModel
import com.example.coinsapp.presentation.ui.modelsui.CoinModelUI
import com.example.coinsapp.presentation.ui.modelsui.toUI
import com.example.coinsapp.presentation.ui.state.UIState
import com.example.domain.usecase.FetchCoinUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CoinViewModel @Inject constructor(
    private val fetchCoinsUseCase: FetchCoinUseCase
) : BaseViewModel() {

    private val _coinState = MutableLiveData<UIState<List<CoinModelUI>>>()
    val coinState: LiveData<UIState<List<CoinModelUI>>> = _coinState

    init {
        fetchCoins()
    }

    private fun fetchCoins() {
        fetchCoinsUseCase().collectRequest(_coinState){
            it.map { it.toUI() }
        }
    }
}