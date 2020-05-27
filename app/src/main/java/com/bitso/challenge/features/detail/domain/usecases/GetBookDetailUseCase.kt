/*
 * GetBookDetailUseCase.kt - app
 * Created by iamlordalvarado on 5/27/20 1:15 PM
 * Copyright (c) 2020 . All rights reserved.
 * Last modified 5/27/20 1:15 PM
 */

package com.bitso.challenge.features.detail.domain.usecases

import com.bitso.challenge.core.domain.usecases.UseCase
import com.bitso.challenge.core.exceptions.Failure
import com.bitso.challenge.core.extensions.Either
import com.bitso.challenge.features.list.domain.models.Ticker
import com.bitso.challenge.features.list.domain.repositories.BooksRepository
import com.bitso.challenge.features.list.domain.stores.FetchTickerException

class GetBookDetailUseCase(
    private val booksRepository: BooksRepository
) : UseCase<String, Ticker>() {

    override suspend fun execute(params: String): Either<Failure, Ticker> {
        return try {
            val ticker = booksRepository.fetchTicker(params)
            if (ticker != null) {
                Either.Right(ticker)
            } else {
                Either.Left(FetchTickerException())
            }
        } catch (ex: Exception) {
            Either.Left(ex as Failure)
        }
    }
}
