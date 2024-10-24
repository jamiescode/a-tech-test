package com.a.technicaltest.data

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Market(
    @SerializedName("Epic")
    val epic: String,
    @SerializedName("CompanyName")
    val companyName: String,
    @SerializedName("CurrentPrice")
    val currentPrice: Double,
    @SerializedName("CurrentChange")
    val currentChange: Double,
    @SerializedName("CurrentChangePct")
    val currentChangePercentage: Double,
) : Parcelable
