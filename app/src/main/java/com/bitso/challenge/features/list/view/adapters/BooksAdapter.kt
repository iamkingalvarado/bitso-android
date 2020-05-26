/*
 * BooksAdapter.kt - app
 * Created by iamlordalvarado on 5/26/20 4:34 PM
 * Copyright (c) 2020 . All rights reserved.
 * Last modified 5/26/20 4:34 PM
 */

package com.bitso.challenge.features.list.view.adapters

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bitso.challenge.R
import com.bitso.challenge.features.list.view.models.BookUI

class BooksAdapter : RecyclerView.Adapter<BooksAdapter.BooksViewHolder>() {

    private var books: List<BookUI> = arrayListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BooksViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_available_book, parent, false)
        return BooksViewHolder(view)
    }

    override fun getItemCount(): Int = books.size

    override fun onBindViewHolder(holder: BooksViewHolder, position: Int) {
        holder.bind(this.books[position])
    }

    fun update(booksUI: List<BookUI>) {
        this.books = booksUI
        notifyDataSetChanged()
    }

    class BooksViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val itemAvailableBookNameTextView =
            itemView.findViewById<TextView>(R.id.itemAvailableBookNameTextView)
        private val itemAvailableBookDateTextView =
            itemView.findViewById<TextView>(R.id.itemAvailableBookDateTextView)
        private val itemAvailableBookLastPrice =
            itemView.findViewById<TextView>(R.id.itemAvailableBookLastPrice)
        private val itemAvailableBookColorLayout =
            itemView.findViewById<View>(R.id.itemAvailableBookColorLayout)

        fun bind(bookUI: BookUI) {
            itemAvailableBookNameTextView.text = bookUI.name
            itemAvailableBookDateTextView.text = bookUI.date
            itemAvailableBookLastPrice.text = bookUI.lastPrice
            itemAvailableBookColorLayout.setBackgroundColor(Color.parseColor(bookUI.hexColor))
        }
    }
}
