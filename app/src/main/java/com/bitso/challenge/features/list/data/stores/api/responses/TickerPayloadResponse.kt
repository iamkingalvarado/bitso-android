/*
 * TickerPayloadResponse.kt - app
 * Created by iamlordalvarado on 5/26/20 7:12 PM
 * Copyright (c) 2020 . All rights reserved.
 * Last modified 5/26/20 7:12 PM
 */

package com.bitso.challenge.features.list.data.stores.api.responses

import com.google.gson.annotations.SerializedName

data class TickerPayloadResponse(

    @SerializedName("success")
    val success: Boolean,

    @SerializedName("payload")
    val ticker: TickerResponse
)
