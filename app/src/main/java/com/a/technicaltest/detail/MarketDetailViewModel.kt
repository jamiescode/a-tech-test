package com.a.technicaltest.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.a.technicaltest.data.Market
import kotlinx.coroutines.launch

internal class MarketDetailViewModel : ViewModel() {
    private val _stateLiveData: MutableLiveData<State> by lazy {
        MutableLiveData<State>(State.Loading)
    }
    val stateLiveData = _stateLiveData as LiveData<State>

    fun setMarket(market: Market) {
        viewModelScope.launch {
            _stateLiveData.value = State.Loaded(market)
        }
    }

    sealed class State {
        data object Loading : State()

        data class Loaded(
            val market: Market,
        ) : State()
    }
}
