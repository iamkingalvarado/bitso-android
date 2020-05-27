/*
 * BookDetailViewModel.kt - app
 * Created by iamlordalvarado on 5/27/20 1:14 PM
 * Copyright (c) 2020 . All rights reserved.
 * Last modified 5/27/20 1:14 PM
 */

package com.bitso.challenge.features.detail.view.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bitso.challenge.core.exceptions.Failure
import com.bitso.challenge.core.extensions.unwrap
import com.bitso.challenge.features.detail.domain.usecases.GetBookDetailUseCase
import com.bitso.challenge.features.detail.view.views.BookDetailView
import com.bitso.challenge.features.list.domain.models.Ticker
import java.lang.ref.WeakReference

class BookDetailViewModel(
    private val bookDetailUseCase: GetBookDetailUseCase
) : ViewModel() {

    private var book: String? = null
    private var view: WeakReference<BookDetailView>? = null

    fun setView(view: BookDetailView, book: String) {
        this.view = WeakReference(view)
        this.book = book
    }

    fun loadBookInfo() {
        book?.let { book ->
            this.view.unwrap { it.showLoading() }
            this.bookDetailUseCase.invoke(viewModelScope, book) {
                it.either(::handleFailure, ::handleSuccess)
            }
        }
    }

    private fun handleSuccess(ticker: Ticker) {
        this.view.unwrap {
            it.hideLoading()
            it.showInformation(ticker)
        }
    }

    private fun handleFailure(failure: Failure) {
        failure.printStackTrace()
        this.view.unwrap {
            it.hideLoading()
            it.showError()
        }
    }
}
