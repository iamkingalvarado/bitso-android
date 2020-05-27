package com.bitso.challenge.features.list.view.activities

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import com.bitso.challenge.R
import com.bitso.challenge.features.detail.view.activities.BookDetailActivity
import com.bitso.challenge.features.list.view.adapters.BooksAdapter
import com.bitso.challenge.features.list.view.listeners.OnBookClickListener
import com.bitso.challenge.features.list.view.models.BookUI
import com.bitso.challenge.features.list.view.viewmodels.AvailableBooksViewModel
import com.bitso.challenge.features.list.view.views.AvailableBooksView
import com.bitso.challenge.ui.extensions.show
import kotlinx.android.synthetic.main.activity_available_books.*
import kotlinx.android.synthetic.main.layout_loading_and_error.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class AvailableBooksActivity : AppCompatActivity(), AvailableBooksView {

    private val availableBooksViewModel: AvailableBooksViewModel by viewModel()
    private var clickListener = object : OnBookClickListener {
        override fun onBookSelected(bookUI: BookUI) {
            show<BookDetailActivity> {
                it.putExtra(BookDetailActivity.EXTRA_BOOK, bookUI)
            }
        }
    }
    private val booksAdapter = BooksAdapter(clickListener = clickListener)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_available_books)

        availableBooksViewModel.setView(view = this)
        availableBooksViewModel.loadBooks()

        setupViews()
    }

    override fun showLoading() {
        availableBooksRecyclerView.visibility = View.GONE
        errorFailureLayout.visibility = View.GONE
        loadingProgressBar.visibility = View.VISIBLE
    }

    override fun hideLoading() {
        availableBooksRecyclerView.visibility = View.GONE
        errorFailureLayout.visibility = View.GONE
        loadingProgressBar.visibility = View.GONE
    }

    override fun showBooks(booksUI: List<BookUI>) {
        availableBooksRecyclerView.visibility = View.VISIBLE
        booksAdapter.update(booksUI)
    }

    override fun showError() {
        errorFailureLayout.visibility = View.VISIBLE
    }

    private fun setupViews() {
        errorRetryButton.setOnClickListener {
            availableBooksViewModel.loadBooks()
        }
        availableBooksRecyclerView.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        availableBooksRecyclerView.setHasFixedSize(true)
        availableBooksRecyclerView.itemAnimator = DefaultItemAnimator()
        availableBooksRecyclerView.adapter = booksAdapter
    }
}
