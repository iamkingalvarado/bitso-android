package com.bitso.challenge.features.list.data.stores

import com.bitso.challenge.core.mapping.Mapper
import com.bitso.challenge.features.list.data.stores.local.BooksDao
import com.bitso.challenge.features.list.data.stores.local.mappers.BooksEntityMapper
import com.bitso.challenge.features.list.data.stores.local.mappers.TickerEntityMapper
import com.bitso.challenge.features.list.data.stores.local.models.BookEntity
import com.bitso.challenge.features.list.data.stores.local.models.TickerEntity
import com.bitso.challenge.features.list.domain.models.Book
import com.bitso.challenge.features.list.domain.models.Ticker
import com.bitso.challenge.features.list.domain.stores.BooksStore

class RoomBooksStore(
    private val booksDao: BooksDao,
    private val booksMapper: Mapper<BookEntity, Book> = BooksEntityMapper(),
    private val tickerMapper: Mapper<TickerEntity, Ticker> = TickerEntityMapper()
) : BooksStore {

    override suspend fun fetchBooks(): List<Book> {
        return booksMapper.mapList(booksDao.books())
    }

    override suspend fun saveBook(book: Book) {
        booksDao.saveBook(booksMapper.mapReverse(book))
    }

    override suspend fun deleteAll() {
        booksDao.deleteAll()
    }

    override suspend fun fetchTicker(book: String): Ticker? {
        return booksDao.ticker(book = book)?.let { tickerMapper.map(it) }
    }

    override suspend fun saveTicker(ticker: Ticker) {
        booksDao.saveTicker(tickerMapper.mapReverse(ticker))
    }

}
