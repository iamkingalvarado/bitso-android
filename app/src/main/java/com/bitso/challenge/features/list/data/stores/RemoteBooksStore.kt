/*
 * RemoteBooksStore.kt - app
 * Created by iamlordalvarado on 5/26/20 6:47 PM
 * Copyright (c) 2020 . All rights reserved.
 * Last modified 5/26/20 6:47 PM
 */

package com.bitso.challenge.features.list.data.stores

import com.bitso.challenge.core.mapping.Mapper
import com.bitso.challenge.features.list.data.stores.api.BitsoApi
import com.bitso.challenge.features.list.data.stores.api.mappers.BookResponseMapper
import com.bitso.challenge.features.list.data.stores.api.mappers.TickerResponseMapper
import com.bitso.challenge.features.list.data.stores.api.responses.BookResponse
import com.bitso.challenge.features.list.data.stores.api.responses.TickerResponse
import com.bitso.challenge.features.list.domain.models.Book
import com.bitso.challenge.features.list.domain.models.Ticker
import com.bitso.challenge.features.list.domain.stores.BooksStore
import com.bitso.challenge.features.list.domain.stores.FetchBooksException

class RemoteBooksStore(
    private val bitsoApi: BitsoApi,
    private val booksMapper: Mapper<BookResponse, Book> = BookResponseMapper(),
    private val tickerMapper: Mapper<TickerResponse, Ticker> = TickerResponseMapper()
) : BooksStore {

    override suspend fun fetchBooks(): List<Book> {
        val response = bitsoApi.books()
        if (response.success) {
            return booksMapper.mapList(response.books)
        }
        throw FetchBooksException()
    }

    override suspend fun saveBook(book: Book) {
        throw UnsupportedOperationException()
    }

    override suspend fun deleteAll() {
        throw UnsupportedOperationException()
    }

    override suspend fun fetchTicker(book: String): Ticker? {
        val response = bitsoApi.ticker(book = book)
        if (response.success) {
            return tickerMapper.map(response.ticker)
        }
        return null
    }

    override suspend fun saveTicker(ticker: Ticker) {
        throw UnsupportedOperationException()
    }

}
