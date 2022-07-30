package com.example.coinsapp.ui.fragments

import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.coinsapp.R
import com.example.coinsapp.base.BaseFragment
import com.example.coinsapp.databinding.FragmentCoinBinding
import com.example.coinsapp.ui.adapters.CoinAdapter
import com.example.coinsapp.utils.Either
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CoinFragment : BaseFragment<CoinViewModel, FragmentCoinBinding>(
    R.layout.fragment_coin
) {

    override val viewModel: CoinViewModel by viewModels()
    override val binding by viewBinding(FragmentCoinBinding::bind)
    private val coinAdapter = CoinAdapter()

    override fun initialize() {
        setupAdapter()
    }

    private fun setupAdapter() = with(binding.recycler) {
        layoutManager =  LinearLayoutManager(requireContext())
        adapter = coinAdapter
    }

    override fun setupSubscribe() {
        binding.progressBar.visibility = View.VISIBLE
        viewModel.fetchCoins().observe(viewLifecycleOwner){
            when(it){
                is Either.Left -> {
                    Log.e("son", it.value)
                }
                is Either.Right -> {
                    binding.progressBar.visibility = View.GONE
                    coinAdapter.submitList(it.value)
                    Log.e("son", it.value.toString())
                }
            }
        }
    }
}