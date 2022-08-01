package com.example.coinsapp.presentation.ui.fragments

import android.util.Log
import android.view.View
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.coinsapp.R
import com.example.coinsapp.databinding.FragmentCoinBinding
import com.example.coinsapp.presentation.ui.adapters.CoinAdapter
import com.example.coinsapp.presentation.ui.base.BaseFragment
import com.example.coinsapp.presentation.ui.state.UIState
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
        layoutManager = LinearLayoutManager(requireContext())
        adapter = coinAdapter
    }

    override fun setupSubscribe() {
        binding.progressBar.visibility = View.VISIBLE
        viewModel.coinState.observe(viewLifecycleOwner) {
            when (it) {
                is UIState.Error -> {
                    Log.e("son", it.error)
                }
                is UIState.Success -> {
                    binding.progressBar.visibility = View.GONE
                    coinAdapter.submitList(it.data)
                }
                else -> {}
            }
        }
    }
}