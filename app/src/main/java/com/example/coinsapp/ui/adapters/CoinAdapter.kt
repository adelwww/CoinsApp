package com.example.coinsapp.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.coinsapp.data.models.CoinModel
import com.example.coinsapp.databinding.ItemCoinsBinding

class CoinAdapter : ListAdapter<CoinModel, CoinAdapter.CoinViewHolder>(
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
        fun onBind(model: CoinModel) = with(binding) {
            tvName.text = model.name
        }
    }

}
object CoinDiffCallBack : DiffUtil.ItemCallback<CoinModel>() {
    override fun areItemsTheSame(
        oldItem: CoinModel,
        newItem: CoinModel)
            : Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(
        oldItem: CoinModel,
        newItem: CoinModel
    ): Boolean {
        return oldItem == newItem
    }
}
