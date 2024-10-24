@file:OptIn(ExperimentalMaterial3Api::class)

package com.a.technicaltest.detail

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalView
import androidx.lifecycle.asFlow
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.a.technicaltest.data.Market

@Composable
internal fun MarketDetailScreen(viewModel: MarketDetailViewModel) {
    val navController = LocalView.current.findNavController()
    Scaffold(
        topBar = {
            AppBar(navController)
        },
        content = {
            Box(modifier = Modifier.padding(it)) {
                MarketDetailsScreenContent(viewModel)
            }
        },
    )
}

@Composable
private fun MarketDetailsScreenContent(viewModel: MarketDetailViewModel) {
    val state =
        viewModel.stateLiveData.asFlow().collectAsState(
            initial = MarketDetailViewModel.State.Loading,
        )

    when (val value = state.value) {
        is MarketDetailViewModel.State.Loading -> LoadingScreen()
        is MarketDetailViewModel.State.Loaded -> LoadedScreen(value.market)
    }
}

@Composable
private fun LoadingScreen() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center,
    ) {
        CircularProgressIndicator()
    }
}

@Composable
private fun LoadedScreen(market: Market) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center,
    ) {
        Text(text = "Company name: ${market.companyName}")
    }
}

@Suppress("MagicNumber")
@Composable
private fun AppBar(navController: NavController) {
    TopAppBar(
        title = { Text(text = "Details", color = Color.White) },
        navigationIcon = @Composable {
            IconButton(onClick = { navController.popBackStack() }) {
                Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
            }
        },
        modifier = Modifier.statusBarsPadding(),
        colors =
            TopAppBarDefaults.topAppBarColors(
                containerColor = Color(0xFF6200EE),
                navigationIconContentColor = Color.White,
            ),
    )
}
