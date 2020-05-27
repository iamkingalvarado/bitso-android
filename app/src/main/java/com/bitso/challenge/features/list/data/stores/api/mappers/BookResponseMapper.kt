/*
 * BookResponseMapper.kt - app
 * Created by iamlordalvarado on 5/26/20 7:10 PM
 * Copyright (c) 2020 . All rights reserved.
 * Last modified 5/26/20 7:10 PM
 */

package com.bitso.challenge.features.list.data.stores.api.mappers

import com.bitso.challenge.core.mapping.Mapper
import com.bitso.challenge.features.list.data.stores.api.responses.BookResponse
import com.bitso.challenge.features.list.domain.models.Book

class BookResponseMapper : Mapper<BookResponse, Book>() {
    override fun map(from: BookResponse): Book {
        return Book(from.name)
    }
}
