/*
 * TickerEntity.kt - app
 * Created by iamlordalvarado on 5/26/20 6:52 PM
 * Copyright (c) 2020 . All rights reserved.
 * Last modified 5/26/20 6:52 PM
 */

package com.bitso.challenge.features.list.data.stores.local.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.threeten.bp.OffsetDateTime

@Entity(tableName = "Ticker")
data class TickerEntity(
    @PrimaryKey
    val book: String,
    val last: Double,
    val low: Double,
    val high: Double,
    val volume: Double,
    val vwap: Double,
    val ask: Double,
    val bid: Double,
    @ColumnInfo(name = "created_at")
    val createdAt: OffsetDateTime
)
