package com.example.coinsapp.presentation.ui.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.coinsapp.presentation.ui.state.UIState
import com.example.domain.either.Either
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

open class BaseViewModel : ViewModel() {

    protected fun <T, S> Flow<Either<String, T>>.collectRequest(
        state: MutableLiveData<UIState<S>>,
        mapData: (T) -> S
    ) {
        viewModelScope.launch(Dispatchers.IO) {
            this@collectRequest.collect {
                when (it) {
                    is Either.Left -> state.value = UIState.Error(it.value)
                    is Either.Right -> state.value = UIState.Success(mapData(it.value))
                }
            }
        }
    }
}