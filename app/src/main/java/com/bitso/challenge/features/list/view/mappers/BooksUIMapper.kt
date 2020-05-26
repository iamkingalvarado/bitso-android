/*
 * BooksUIMapper.kt - app
 * Created by iamlordalvarado on 5/26/20 4:51 PM
 * Copyright (c) 2020 . All rights reserved.
 * Last modified 5/26/20 4:51 PM
 */

package com.bitso.challenge.features.list.view.mappers

import com.bitso.challenge.core.mapping.Mapper
import com.bitso.challenge.features.list.domain.models.Book
import com.bitso.challenge.features.list.view.models.BookUI
import java.text.DecimalFormat
import java.text.SimpleDateFormat
import java.util.*

class BooksUIMapper : Mapper<Book, BookUI>() {

    private val decimalFormat = DecimalFormat("#,###,##0.00")
    private val dateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.getDefault())

    override fun map(from: Book): BookUI {
        return BookUI(
            name = from.name.toUpperCase(Locale.getDefault()).replace('_', '/'),
            lastPrice = decimalFormat.format(from.lastPrice),
            date = dateFormat.format(from.createdAt),
            hexColor = getRandomColor()
        )
    }

    private fun getRandomColor(): String {
        val random = Random()
        val nextInt = random.nextInt(0xffffff + 1)
        return String.format("#%06x", nextInt)
    }
}
