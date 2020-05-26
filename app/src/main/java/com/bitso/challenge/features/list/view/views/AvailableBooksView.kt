/*
 * AvailableBooksView.kt - app
 * Created by iamlordalvarado on 5/26/20 4:14 PM
 * Copyright (c) 2020 . All rights reserved.
 * Last modified 5/26/20 4:14 PM
 */

package com.bitso.challenge.features.list.view.views

import com.bitso.challenge.features.list.view.models.BookUI

interface AvailableBooksView {
    fun showLoading()
    fun showError()
    fun showBooks(booksUI: List<BookUI>)
    fun hideLoading()
}
