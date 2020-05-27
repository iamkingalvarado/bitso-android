/*
 * BooksRepository.kt - app
 * Created by iamlordalvarado on 5/26/20 6:14 PM
 * Copyright (c) 2020 . All rights reserved.
 * Last modified 5/26/20 6:14 PM
 */

package com.bitso.challenge.features.list.domain.repositories

import com.bitso.challenge.features.list.domain.models.Book
import com.bitso.challenge.features.list.domain.models.Ticker

interface BooksRepository {
    suspend fun fetchAll(): List<Book>
    suspend fun fetchTicker(book: String): Ticker?
}
