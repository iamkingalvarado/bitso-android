/*
 * WeakReference.kt - app
 * Created by iamlordalvarado on 5/26/20 3:56 PM
 * Copyright (c) 2020 . All rights reserved.
 * Last modified 5/26/20 3:56 PM
 */

package com.bitso.challenge.core.extensions

import java.lang.ref.WeakReference

fun <T> WeakReference<T>?.unwrap(block: (T) -> Unit) {
    this?.get()?.let {
        block.invoke(it)
    }
}