/*
 * BookDetailActivity.kt - app
 * Created by iamlordalvarado on 5/26/20 11:11 PM
 * Copyright (c) 2020 . All rights reserved.
 * Last modified 5/26/20 11:11 PM
 */

package com.bitso.challenge.features.detail.view.activities

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.GridLayoutManager
import com.bitso.challenge.R
import com.bitso.challenge.features.detail.view.adapters.BookDetailAdapter
import com.bitso.challenge.features.detail.view.models.BookDetailUI
import com.bitso.challenge.features.detail.view.viewmodels.BookDetailViewModel
import com.bitso.challenge.features.detail.view.views.BookDetailView
import com.bitso.challenge.features.list.domain.models.Ticker
import com.bitso.challenge.features.list.view.models.BookUI
import kotlinx.android.synthetic.main.activity_book_detail.*
import kotlinx.android.synthetic.main.layout_loading_and_error.*
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.text.DecimalFormat

class BookDetailActivity : AppCompatActivity(), BookDetailView {

    companion object {
        const val EXTRA_BOOK = "EXTRA_BOOK"
    }

    private val adapter = BookDetailAdapter()
    private val bookDetailViewModel: BookDetailViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book_detail)

        val bookDetail = intent.getSerializableExtra(EXTRA_BOOK) as BookUI
        setupViews(bookDetail)
        bookDetailViewModel.setView(view = this, book = bookDetail.id)
        bookDetailViewModel.loadBookInfo()
    }

    override fun showLoading() {
        bookDetailContentLayout.visibility = View.GONE
        errorFailureLayout.visibility = View.GONE
        loadingProgressBar.visibility = View.VISIBLE
    }

    override fun showError() {
        errorFailureLayout.visibility = View.VISIBLE
    }

    override fun hideLoading() {
        bookDetailContentLayout.visibility = View.GONE
        errorFailureLayout.visibility = View.GONE
        loadingProgressBar.visibility = View.GONE
    }

    override fun showInformation(ticker: Ticker) {
        bookDetailContentLayout.visibility = View.VISIBLE

        val decimalFormat = DecimalFormat("$#,###,##0.0000")
        val information = arrayListOf(
            BookDetailUI(
                getString(R.string.act_book_detail_volume),
                decimalFormat.format(ticker.volume)
            ),
            BookDetailUI(
                getString(R.string.act_book_detail_high),
                decimalFormat.format(ticker.high)
            ),
            BookDetailUI(
                getString(R.string.act_book_detail_last),
                decimalFormat.format(ticker.last)
            ),
            BookDetailUI(getString(R.string.act_book_detail_low), decimalFormat.format(ticker.low)),
            BookDetailUI(
                getString(R.string.act_book_detail_vwap),
                decimalFormat.format(ticker.vwap)
            ),
            BookDetailUI(getString(R.string.act_book_detail_ask), decimalFormat.format(ticker.ask)),
            BookDetailUI(getString(R.string.act_book_detail_bid), decimalFormat.format(ticker.bid))
        )
        adapter.update(information)
    }

    private fun setupViews(bookDetail: BookUI) {
        errorRetryButton.setOnClickListener {
            bookDetailViewModel.loadBookInfo()
        }
        bookDetailToolbar.title = bookDetail.name
        bookDetailRecyclerView.layoutManager = GridLayoutManager(this, 2)
        bookDetailRecyclerView.setHasFixedSize(false)
        bookDetailRecyclerView.itemAnimator = DefaultItemAnimator()
        bookDetailRecyclerView.adapter = adapter
    }
}
