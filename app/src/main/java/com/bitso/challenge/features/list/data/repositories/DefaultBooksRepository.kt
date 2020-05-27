/*
 * DefaultBooksRepository.kt - app
 * Created by iamlordalvarado on 5/26/20 6:32 PM
 * Copyright (c) 2020 . All rights reserved.
 * Last modified 5/26/20 6:32 PM
 */

package com.bitso.challenge.features.list.data.repositories

import com.bitso.challenge.features.list.domain.models.Book
import com.bitso.challenge.features.list.domain.models.Ticker
import com.bitso.challenge.features.list.domain.repositories.BooksRepository
import com.bitso.challenge.features.list.domain.stores.BooksStore

class DefaultBooksRepository(
    private val localStore: BooksStore,
    private val remoteStore: BooksStore
) : BooksRepository {

    override suspend fun fetchAll(): List<Book> {
        return try {
            /*
                    If updates are not so regular, here can be made a real logic for caching like
                    last update time and cache strategies, etc. Currently just a delete all and
                    save all strategy is taken.
                 */
            val books = remoteStore.fetchBooks()
            localStore.deleteAll()
            for (book in books) {
                localStore.saveBook(book)
            }
            books
        } catch (ex: Exception) {
            localStore.fetchBooks()
        }
    }

    override suspend fun fetchTicker(book: String): Ticker? {
        return try {
            val ticker = remoteStore.fetchTicker(book = book)
            ticker?.let {
                localStore.saveTicker(ticker)
            }
            ticker
        } catch (ex: Exception) {
            localStore.fetchTicker(book = book)
        }
    }
}
