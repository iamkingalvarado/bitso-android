/*
 * BookDetailAdapter.kt - app
 * Created by iamlordalvarado on 5/27/20 1:05 PM
 * Copyright (c) 2020 . All rights reserved.
 * Last modified 5/27/20 1:05 PM
 */

package com.bitso.challenge.features.detail.view.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bitso.challenge.R
import com.bitso.challenge.features.detail.view.models.BookDetailUI
import java.util.*

class BookDetailAdapter : RecyclerView.Adapter<BookDetailAdapter.BookDetailViewHolder>() {

    private var items: List<BookDetailUI> = arrayListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookDetailViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_book_detail, parent, false)
        return BookDetailViewHolder(view)
    }

    override fun getItemCount(): Int = this.items.size

    override fun onBindViewHolder(holder: BookDetailViewHolder, position: Int) {
        holder.bind(this.items[position])
    }

    fun update(items: ArrayList<BookDetailUI>) {
        this.items = items
        notifyDataSetChanged()
    }

    class BookDetailViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val itemBookDetailName = itemView.findViewById<TextView>(R.id.itemBookDetailName)
        private val itemBookDetailValue = itemView.findViewById<TextView>(R.id.itemBookDetailValue)

        fun bind(bookDetailUI: BookDetailUI) {
            itemBookDetailName.text = bookDetailUI.name
            itemBookDetailValue.text = bookDetailUI.value
        }
    }
}
