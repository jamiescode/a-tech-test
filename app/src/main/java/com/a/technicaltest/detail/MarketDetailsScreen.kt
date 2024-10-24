@file:OptIn(ExperimentalMaterial3Api::class)

package com.a.technicaltest.detail

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalView
import androidx.lifecycle.asFlow
import androidx.navigation.findNavController
import com.a.technicaltest.detail.composable.AppBar
import com.a.technicaltest.detail.composable.LoadingScreen
import com.a.technicaltest.detail.composable.MarketDetailsContent

@Composable
internal fun MarketDetailScreen(viewModel: MarketDetailViewModel) {
    val navController = LocalView.current.findNavController()
    MaterialTheme {
        Scaffold(
            topBar = {
                AppBar(
                    onGoBack = { navController.popBackStack() },
                )
            },
            content = {
                Box(modifier = Modifier.padding(it)) {
                    val state =
                        viewModel.uiState.asFlow().collectAsState(
                            initial = MarketDetailViewModel.State.Loading,
                        )

                    when (val value = state.value) {
                        is MarketDetailViewModel.State.Loading -> LoadingScreen()
                        is MarketDetailViewModel.State.Loaded -> MarketDetailsContent(value.market)
                    }
                }
            },
        )
    }
}
