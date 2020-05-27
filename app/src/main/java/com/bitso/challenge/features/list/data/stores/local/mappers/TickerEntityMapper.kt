/*
 * TickerEntityMapper.kt - app
 * Created by iamlordalvarado on 5/26/20 7:02 PM
 * Copyright (c) 2020 . All rights reserved.
 * Last modified 5/26/20 7:02 PM
 */

package com.bitso.challenge.features.list.data.stores.local.mappers

import com.bitso.challenge.core.mapping.Mapper
import com.bitso.challenge.features.list.data.stores.local.models.TickerEntity
import com.bitso.challenge.features.list.domain.models.Ticker

class TickerEntityMapper : Mapper<TickerEntity, Ticker>() {
    override fun map(from: TickerEntity): Ticker {
        return Ticker(
            book = from.book,
            last = from.last,
            low = from.low,
            high = from.high,
            volume = from.volume,
            vwap = from.vwap,
            ask = from.ask,
            bid = from.bid,
            createdAt = from.createdAt
        )
    }

    override fun mapReverse(from: Ticker): TickerEntity {
        return TickerEntity(
            book = from.book,
            last = from.last,
            low = from.low,
            high = from.high,
            volume = from.volume,
            vwap = from.vwap,
            ask = from.ask,
            bid = from.bid,
            createdAt = from.createdAt
        )
    }
}
