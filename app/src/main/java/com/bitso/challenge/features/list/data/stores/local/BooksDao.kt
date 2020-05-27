/*
 * BooksDao.kt - app
 * Created by iamlordalvarado on 5/26/20 6:50 PM
 * Copyright (c) 2020 . All rights reserved.
 * Last modified 5/26/20 6:50 PM
 */

package com.bitso.challenge.features.list.data.stores.local

import androidx.room.*
import com.bitso.challenge.features.list.data.stores.local.models.BookEntity
import com.bitso.challenge.features.list.data.stores.local.models.TickerEntity

@Dao
interface BooksDao {
    @Query("SELECT * FROM Book ORDER BY name DESC")
    suspend fun books(): List<BookEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveBook(book: BookEntity)

    @Transaction
    suspend fun deleteAll() {
        deleteAllBooks()
        deleteAllTickers()
    }

    @Query("DELETE FROM Book")
    suspend fun deleteAllBooks()

    @Query("DELETE FROM Ticker")
    suspend fun deleteAllTickers()

    @Query("SELECT * FROM Ticker WHERE book = :book LIMIT 1")
    suspend fun ticker(book: String): TickerEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveTicker(ticker: TickerEntity)
}
