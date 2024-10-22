package com.ajbell.technicaltest.list

import com.ajbell.technicaltest.data.GetMarketsResponse

internal sealed class MarketListEvent {
    class ShowMarketDetail(val market: GetMarketsResponse.Market) : MarketListEvent()
}