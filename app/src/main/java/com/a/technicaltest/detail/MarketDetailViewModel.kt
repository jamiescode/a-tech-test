package com.a.technicaltest.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.a.technicaltest.data.Market
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

internal class MarketDetailViewModel : ViewModel() {
    private val _uiState: MutableLiveData<State> by lazy {
        MutableLiveData<State>(State.Loading)
    }
    val uiState = _uiState as LiveData<State>

    fun setMarket(market: Market) {
        viewModelScope.launch {
            // Added a delay to simulate a network request that would normally happen here
            // This is only to highlight the fact that I have a loading state
            // I would remove this code if the app were to go into production
            @Suppress("MagicNumber")
            delay(500)
            _uiState.value = State.Loaded(market)
        }
    }

    sealed class State {
        data object Loading : State()

        data class Loaded(
            val market: Market,
        ) : State()
    }
}
