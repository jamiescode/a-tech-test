package com.a.technicaltest.detail.composable

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.a.technicaltest.data.Market

@Composable
fun MarketDetailsContent(market: Market) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center,
    ) {
        Text(text = "Company name: ${market.companyName}")
    }
}

@Preview
@Composable
fun MarketDetailsContentPreview() {
    val market =
        Market(
            epic = "EPIC",
            companyName = "COMPANY NAME",
            currentPrice = 120.0,
            currentChange = 30.0,
            currentChangePercentage = 25.0,
        )
    MaterialTheme {
        Box(modifier = Modifier.fillMaxSize()) {
            MarketDetailsContent(market)
        }
    }
}
