package com.a.technicaltest.list

import com.a.technicaltest.data.Market

internal sealed class MarketListEvent {
    class ShowMarketDetail(
        val market: Market,
    ) : MarketListEvent()
}
