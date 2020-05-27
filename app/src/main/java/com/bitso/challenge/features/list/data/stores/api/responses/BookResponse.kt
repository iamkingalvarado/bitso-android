/*
 * BookResponse.kt - app
 * Created by iamlordalvarado on 5/26/20 7:07 PM
 * Copyright (c) 2020 . All rights reserved.
 * Last modified 5/26/20 7:07 PM
 */

package com.bitso.challenge.features.list.data.stores.api.responses

import com.google.gson.annotations.SerializedName

data class BookResponse(
    @SerializedName("book")
    val name: String
)
