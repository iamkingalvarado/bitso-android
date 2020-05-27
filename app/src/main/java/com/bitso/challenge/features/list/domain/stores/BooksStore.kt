/*
 * BooksStore.kt - app
 * Created by iamlordalvarado on 5/26/20 6:31 PM
 * Copyright (c) 2020 . All rights reserved.
 * Last modified 5/26/20 6:31 PM
 */

package com.bitso.challenge.features.list.domain.stores

import com.bitso.challenge.core.exceptions.Failure
import com.bitso.challenge.features.list.domain.models.Book
import com.bitso.challenge.features.list.domain.models.Ticker

class FetchBooksException : Failure()
class FetchTickerException : Failure()

interface BooksStore {
    suspend fun fetchBooks(): List<Book>
    suspend fun saveBook(book: Book)
    suspend fun deleteAll()
    suspend fun fetchTicker(book: String): Ticker?
    suspend fun saveTicker(ticker: Ticker)

}
