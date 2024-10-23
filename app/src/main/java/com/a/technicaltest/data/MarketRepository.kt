package com.a.technicaltest.data

import com.a.technicaltest.InterviewApplication
import com.google.gson.GsonBuilder

internal class MarketRepository {
    fun getMarkets(): GetMarketsResponse {
        val marketsJson: String =
            InterviewApplication.context.assets
                .open("markets.json")
                .bufferedReader()
                .use { it.readText() }
        return GsonBuilder().create().fromJson(marketsJson, GetMarketsResponse::class.java)
    }
}
