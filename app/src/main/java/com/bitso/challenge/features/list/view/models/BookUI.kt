/*
 * BookUI.kt - app
 * Created by iamlordalvarado on 5/26/20 4:21 PM
 * Copyright (c) 2020 . All rights reserved.
 * Last modified 5/26/20 4:21 PM
 */

package com.bitso.challenge.features.list.view.models

import java.io.Serializable

data class BookUI(
    val id: String,
    val name: String,
    val lastPrice: String,
    val date: String?,
    val hexColor: String
) : Serializable
