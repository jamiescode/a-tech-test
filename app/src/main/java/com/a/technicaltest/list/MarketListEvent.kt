package com.a.technicaltest.list

import com.a.technicaltest.data.GetMarketsResponse

internal sealed class MarketListEvent {
    class ShowMarketDetail(
        val market: GetMarketsResponse.Market,
    ) : MarketListEvent()
}
