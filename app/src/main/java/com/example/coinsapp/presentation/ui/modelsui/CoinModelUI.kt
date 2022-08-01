package com.example.coinsapp.presentation.ui.modelsui

import com.example.coinsapp.domain.model.CoinModel

data class CoinModelUI(
    val id: String,
    val name: String,
    val symbol: String,
    val rank: Int,
    val isNew: Boolean,
    val isActive: Boolean
)

fun CoinModel.toUI() = CoinModelUI(id, name, symbol, rank, isNew, isActive)
