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
import java.util.*

class GetAvailableBooksUseCase : UseCase<Any?, List<Book>>() {
    override suspend fun execute(params: Any?): Either<Failure, List<Book>> {
        return try {
            Either.Right(arrayListOf(Book("btc_mxn", 19000.0, Date())))
        } catch (ex: Exception) {
            Either.Left(ex as Failure)
        }
    }
}
