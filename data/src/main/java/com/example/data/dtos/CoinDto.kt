package com.example.data.dtos

import com.example.domain.models.CoinModel
import com.google.gson.annotations.SerializedName

data class CoinDto (

    @SerializedName("id")
    val id: String,

    @SerializedName("name")
    val name: String,

    @SerializedName("symbol")
    val symbol: String,

    @SerializedName("rank")
    val rank: Int,

    @SerializedName("is_new")
    val isNew: Boolean,

    @SerializedName("is_active")
    val isActive: Boolean
)

fun CoinDto.toDomain() = CoinModel(id,name,symbol,rank,isNew,isActive)