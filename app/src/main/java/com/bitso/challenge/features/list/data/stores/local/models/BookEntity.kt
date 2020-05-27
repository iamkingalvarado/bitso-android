/*
 * BookEntity.kt - app
 * Created by iamlordalvarado on 5/26/20 6:51 PM
 * Copyright (c) 2020 . All rights reserved.
 * Last modified 5/26/20 6:51 PM
 */

package com.bitso.challenge.features.list.data.stores.local.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Book")
data class BookEntity(
    @PrimaryKey
    val name: String
)
