/*
 * GetAvailableBooksUseCase.kt - app
 * Created by iamlordalvarado on 5/26/20 4:16 PM
 * Copyright (c) 2020 . All rights reserved.
 * Last modified 5/26/20 4:16 PM
 */

package com.bitso.challenge.features.list.domain.usecases

import com.bitso.challenge.core.domain.usecases.UseCase
import com.bitso.challenge.core.exceptions.Failure
import com.bitso.challenge.core.extensions.Either
import com.bitso.challenge.features.list.domain.models.Book
import com.bitso.challenge.features.list.domain.repositories.BooksRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlin.coroutines.suspendCoroutine

class GetAvailableBooksUseCase(
    private val booksRepository: BooksRepository
) : UseCase<Any?, List<Book>>() {

    override suspend fun execute(params: Any?): Either<Failure, List<Book>> {
        return try {
            val books = booksRepository.fetchAll()
            val fetchedBooks = suspendCoroutine<List<Book>> { suspendable ->
                /*
                 * All the tickers will be fetched in parallel and the execution will continue until all the books are fetched
                 */
                val parentJob = CoroutineScope(Dispatchers.IO).launch {
                    for (book in books) {
                        launch {
                            val ticker = booksRepository.fetchTicker(book = book.name)
                            book.lastPrice = ticker?.last ?: 0.0
                            book.createdAt = ticker?.createdAt
                        }
                    }
                }
                parentJob.invokeOnCompletion {
                    suspendable.resumeWith(Result.success(books))
                }
            }
            Either.Right(fetchedBooks)
        } catch (ex: Exception) {
            Either.Left(ex as Failure)
        }
    }
}
