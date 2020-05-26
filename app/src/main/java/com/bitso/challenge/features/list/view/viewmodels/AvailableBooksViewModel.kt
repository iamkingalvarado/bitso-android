/*
 * AvailableBooksViewModel.kt - app
 * Created by iamlordalvarado on 5/26/20 4:13 PM
 * Copyright (c) 2020 . All rights reserved.
 * Last modified 5/26/20 4:13 PM
 */

package com.bitso.challenge.features.list.view.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bitso.challenge.core.exceptions.Failure
import com.bitso.challenge.core.extensions.unwrap
import com.bitso.challenge.core.mapping.Mapper
import com.bitso.challenge.features.list.domain.models.Book
import com.bitso.challenge.features.list.domain.usecases.GetAvailableBooksUseCase
import com.bitso.challenge.features.list.view.mappers.BooksUIMapper
import com.bitso.challenge.features.list.view.models.BookUI
import com.bitso.challenge.features.list.view.views.AvailableBooksView
import java.lang.ref.WeakReference

class AvailableBooksViewModel(
    private val useCase: GetAvailableBooksUseCase,
    private val booksUIMapper: Mapper<Book, BookUI> = BooksUIMapper()
) : ViewModel() {

    private var view: WeakReference<AvailableBooksView>? = null

    fun setView(view: AvailableBooksView) {
        this.view = WeakReference(view)
    }

    fun loadBooks() {
        this.view.unwrap { it.showLoading() }
        this.useCase.invoke(viewModelScope, null, delayMillis = 800) {
            it.either(::handleError, ::handleSuccess)
        }
    }

    private fun handleSuccess(books: List<Book>) {
        val booksUI = booksUIMapper.mapList(books)
        this.view.unwrap {
            it.hideLoading()
            it.showBooks(booksUI)
        }
    }

    private fun handleError(failure: Failure) {
        failure.printStackTrace()
        this.view.unwrap { it.showError() }
    }

}
