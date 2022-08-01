package com.example.coinsapp.presentation.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.coinsapp.databinding.ItemCoinsBinding
import com.example.coinsapp.presentation.ui.modelsui.CoinModelUI

class CoinAdapter : ListAdapter<CoinModelUI, CoinAdapter.CoinViewHolder>(
    CoinDiffCallBack
) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoinViewHolder {
        return CoinViewHolder(
            ItemCoinsBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: CoinViewHolder, position: Int) {
        getItem(position)?.let { holder.onBind(it) }
    }

    inner class CoinViewHolder(
        private val binding: ItemCoinsBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(model: CoinModelUI) = with(binding) {
            tvName.text = model.name
        }
    }

}
object CoinDiffCallBack : DiffUtil.ItemCallback<CoinModelUI>() {
    override fun areItemsTheSame(
        oldItem: CoinModelUI,
        newItem: CoinModelUI)
            : Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(
        oldItem: CoinModelUI,
        newItem: CoinModelUI
    ): Boolean {
        return oldItem == newItem
    }
}
