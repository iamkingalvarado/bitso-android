/*
 * Book.kt - app
 * Created by iamlordalvarado on 5/26/20 4:16 PM
 * Copyright (c) 2020 . All rights reserved.
 * Last modified 5/26/20 4:16 PM
 */

package com.bitso.challenge.features.list.domain.models

import java.util.*

data class Book(
    val name: String,
    val lastPrice: Double,
    val createdAt: Date
)
