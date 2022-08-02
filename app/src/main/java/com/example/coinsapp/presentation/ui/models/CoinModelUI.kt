package com.example.coinsapp.presentation.ui.models

import com.example.domain.models.CoinModel

data class CoinModelUI(
    val id: String,
    val name: String,
    val symbol: String,
    val rank: Int,
    val isNew: Boolean,
    val isActive: Boolean
)

fun CoinModel.toUI() = CoinModelUI(id, name, symbol, rank, isNew, isActive)
