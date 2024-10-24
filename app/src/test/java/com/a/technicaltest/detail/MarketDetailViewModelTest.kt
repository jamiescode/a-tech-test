package com.a.technicaltest.detail

import androidx.lifecycle.asFlow
import app.cash.turbine.test
import com.a.technicaltest.data.Market
import com.a.technicaltest.testutils.CoroutinesTestDispatcherExtension
import com.a.technicaltest.testutils.InstantTaskExecutorExtension
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.runTest
import org.amshove.kluent.shouldBe
import org.amshove.kluent.shouldBeInstanceOf
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@OptIn(ExperimentalCoroutinesApi::class)
@ExtendWith(InstantTaskExecutorExtension::class, CoroutinesTestDispatcherExtension::class)
class MarketDetailViewModelTest {
    private val viewModel = MarketDetailViewModel()
    private val fakeMarket =
        Market(
            epic = "EPIC",
            companyName = "COMPANY NAME",
            currentPrice = 120.0,
            currentChange = 30.0,
            currentChangePercentage = 25.0,
        )

    @Test
    fun `GIVEN no market data, WHEN no action taken, THEN state should be loading`() =
        runTest {
            // GIVEN no market data

            // WHEN no action taken

            // THEN state should be loading
            viewModel.uiState.asFlow().test {
                awaitItem() shouldBeInstanceOf MarketDetailViewModel.State.Loading::class
            }
        }

    @Test
    fun `GIVEN no market data, WHEN market set, THEN state should change from loading to loaded with the market`() =
        runTest {
            viewModel.uiState.asFlow().test {
                // GIVEN no market data

                // WHEN market set
                runBlocking { viewModel.setMarket(fakeMarket) }

                // THEN state should change from loading to loaded with the market
                awaitItem() shouldBeInstanceOf MarketDetailViewModel.State.Loading::class

                val result = awaitItem()
                result shouldBeInstanceOf MarketDetailViewModel.State.Loaded::class
                (result as MarketDetailViewModel.State.Loaded).market shouldBe fakeMarket
            }
        }
}
