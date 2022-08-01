package com.example.coinsapp.presentation.ui.fragments

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.coinsapp.data.repository.CoinRepositoryImpl
import com.example.coinsapp.presentation.ui.base.BaseViewModel
import com.example.coinsapp.presentation.ui.modelsui.CoinModelUI
import com.example.coinsapp.presentation.ui.modelsui.toUI
import com.example.coinsapp.presentation.ui.state.UIState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CoinViewModel @Inject constructor(
    private val repository: CoinRepositoryImpl
) : BaseViewModel() {

    private val _coinState = MutableLiveData<UIState<List<CoinModelUI>>>()
    val coinState: LiveData<UIState<List<CoinModelUI>>> = _coinState

    init {
        fetchCoins()
    }

    private fun fetchCoins() {
        repository.fetchCoins().collectRequest(_coinState){
            it.map { it.toUI() }
        }
    }
}