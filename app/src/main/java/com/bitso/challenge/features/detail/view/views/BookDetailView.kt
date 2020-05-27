/*
 * BookDetailView.kt - app
 * Created by iamlordalvarado on 5/27/20 1:15 PM
 * Copyright (c) 2020 . All rights reserved.
 * Last modified 5/27/20 1:15 PM
 */

package com.bitso.challenge.features.detail.view.views

import com.bitso.challenge.features.list.domain.models.Ticker

interface BookDetailView {
    fun showLoading()
    fun showError()
    fun hideLoading()
    fun showInformation(ticker: Ticker)
}
