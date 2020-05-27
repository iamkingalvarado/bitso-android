/*
 * TickerResponseMapper.kt - app
 * Created by iamlordalvarado on 5/26/20 9:01 PM
 * Copyright (c) 2020 . All rights reserved.
 * Last modified 5/26/20 9:01 PM
 */

package com.bitso.challenge.features.list.data.stores.api.mappers

import com.bitso.challenge.core.mapping.Mapper
import com.bitso.challenge.features.list.data.stores.api.responses.TickerResponse
import com.bitso.challenge.features.list.domain.models.Ticker

class TickerResponseMapper : Mapper<TickerResponse, Ticker>() {
    override fun map(from: TickerResponse): Ticker {
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

}
