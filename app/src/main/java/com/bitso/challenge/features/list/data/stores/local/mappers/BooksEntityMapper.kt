/*
 * BooksEntityMapper.kt - app
 * Created by iamlordalvarado on 5/26/20 6:56 PM
 * Copyright (c) 2020 . All rights reserved.
 * Last modified 5/26/20 6:56 PM
 */

package com.bitso.challenge.features.list.data.stores.local.mappers

import com.bitso.challenge.core.mapping.Mapper
import com.bitso.challenge.features.list.data.stores.local.models.BookEntity
import com.bitso.challenge.features.list.domain.models.Book

class BooksEntityMapper : Mapper<BookEntity, Book>() {
    override fun map(from: BookEntity): Book {
        return Book(from.name)
    }

    override fun mapReverse(from: Book): BookEntity {
        return BookEntity(name = from.name)
    }
}