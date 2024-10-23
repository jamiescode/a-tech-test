package com.a.technicaltest.data

import com.google.gson.annotations.SerializedName

data class GetMarketsResponse(
    @SerializedName("data")
    val data: List<Market>,
)
