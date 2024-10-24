package com.a.technicaltest.detail.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.a.technicaltest.R
import com.a.technicaltest.data.Market

@Composable
fun MarketDetailsContent(market: Market) {
    Column(
        modifier =
            Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(vertical = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = stringResource(R.string.market_details_title),
            style = MaterialTheme.typography.headlineMedium,
        )
        Spacer(modifier = Modifier.height(8.dp))
        MarketDetailsRow(
            title = stringResource(R.string.market_details_epic_title),
            value = market.epic,
        )
        MarketDetailsRow(
            title = stringResource(R.string.market_details_price_title),
            value = "${market.currentPrice}",
        )
        MarketDetailsRow(
            title = stringResource(R.string.market_details_change_title),
            value = "${market.currentChange}",
        )
        MarketDetailsRow(
            title = stringResource(R.string.market_details_change_percentage_title),
            value = "${market.currentChangePercentage}%",
        )
    }
}

@Preview
@Composable
fun MarketDetailsContentPreview() {
    val market =
        Market(
            epic = "Epic",
            companyName = "Company Name",
            currentPrice = 120.0,
            currentChange = 30.0,
            currentChangePercentage = 25.0,
        )
    MaterialTheme {
        Column {
            MarketDetailsContent(market)
        }
    }
}
