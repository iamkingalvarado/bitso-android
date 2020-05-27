/*
 * Book.kt - app
 * Created by iamlordalvarado on 5/26/20 4:16 PM
 * Copyright (c) 2020 . All rights reserved.
 * Last modified 5/26/20 4:16 PM
 */

package com.bitso.challenge.features.list.domain.models

import org.threeten.bp.OffsetDateTime

data class Book(
    val name: String,
    var createdAt: OffsetDateTime? = null,
    var lastPrice: Double = 0.0
)
