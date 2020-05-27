/*
 * OnBookClickListener.kt - app
 * Created by iamlordalvarado on 5/26/20 11:04 PM
 * Copyright (c) 2020 . All rights reserved.
 * Last modified 5/26/20 11:04 PM
 */

package com.bitso.challenge.features.list.view.listeners

import com.bitso.challenge.features.list.view.models.BookUI

interface OnBookClickListener {
    fun onBookSelected(bookUI: BookUI)
}
