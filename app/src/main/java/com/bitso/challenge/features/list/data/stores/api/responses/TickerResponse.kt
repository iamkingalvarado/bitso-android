/*
 * TickerResponse.kt - app
 * Created by iamlordalvarado on 5/26/20 7:13 PM
 * Copyright (c) 2020 . All rights reserved.
 * Last modified 5/26/20 7:13 PM
 */

package com.bitso.challenge.features.list.data.stores.api.responses

import com.google.gson.annotations.SerializedName
import org.threeten.bp.OffsetDateTime

data class TickerResponse(
    val book: String,
    val last: Double,
    val low: Double,
    val high: Double,
    val volume: Double,
    val vwap: Double,
    val ask: Double,
    val bid: Double,
    @SerializedName("created_at")
    val createdAt: OffsetDateTime,
    @SerializedName("change_24")
    val charge24: String
)
