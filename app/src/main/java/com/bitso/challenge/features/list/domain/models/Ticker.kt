/*
 * Ticker.kt - app
 * Created by iamlordalvarado on 5/26/20 6:18 PM
 * Copyright (c) 2020 . All rights reserved.
 * Last modified 5/26/20 6:18 PM
 */

package com.bitso.challenge.features.list.domain.models

import org.threeten.bp.OffsetDateTime

data class Ticker(
    val book: String,
    val last: Double,
    val low: Double,
    val high: Double,
    val volume: Double,
    val vwap: Double,
    val ask: Double,
    val bid: Double,
    val createdAt: OffsetDateTime
)
