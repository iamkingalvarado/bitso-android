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
import kotlinx.coroutines.launch
import java.lang.ref.WeakReference
import java.util.*

class AvailableBooksViewModel(
    private val useCase: GetAvailableBooksUseCase,
    private val booksUIMapper: Mapper<Book, BookUI> = BooksUIMapper()
) : ViewModel() {

    companion object {
        private const val UPDATE_SECONDS_PERIOD = 30 * 1000L
    }

    private var timer: Timer? = null
    private var view: WeakReference<AvailableBooksView>? = null

    fun setView(view: AvailableBooksView) {
        this.view = WeakReference(view)
    }

    fun loadBooks() {
        checkIfNotTimerInitialized()
        this.view.unwrap { it.showLoading() }
        this.useCase.invoke(viewModelScope, null, delayMillis = 800) {
            it.either(::handleError, ::handleSuccess)
        }
    }

    private fun checkIfNotTimerInitialized() {
        if (timer == null) {
            timer = Timer()
            timer?.scheduleAtFixedRate(object : TimerTask() {
                override fun run() {
                    viewModelScope.launch { loadBooks() }
                }
            }, 300, UPDATE_SECONDS_PERIOD)
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

    override fun onCleared() {
        super.onCleared()
        timer?.cancel()
        timer = null
    }

}
