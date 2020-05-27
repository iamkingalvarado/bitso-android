/*
 * BitsoApi.kt - app
 * Created by iamlordalvarado on 5/26/20 6:47 PM
 * Copyright (c) 2020 . All rights reserved.
 * Last modified 5/26/20 6:47 PM
 */

package com.bitso.challenge.features.list.data.stores.api

import com.bitso.challenge.features.list.data.stores.api.responses.BooksListResponse
import com.bitso.challenge.features.list.data.stores.api.responses.TickerPayloadResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface BitsoApi {

    @GET("available_books/")
    suspend fun books(): BooksListResponse

    @GET("ticker/")
    suspend fun ticker(@Query("book") book: String): TickerPayloadResponse
}
