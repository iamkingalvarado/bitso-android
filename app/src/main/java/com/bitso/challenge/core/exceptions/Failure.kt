/*
 * Failure.kt - app
 * Created by iamlordalvarado on 5/26/20 4:18 PM
 * Copyright (c) 2020 . All rights reserved.
 * Last modified 5/26/20 4:18 PM
 */

package com.bitso.challenge.core.exceptions

open class Failure(private val exception: Exception = Exception("Failure")) :
    Exception(exception) {

    override fun equals(other: Any?): Boolean {
        return other is Failure
    }

    override fun hashCode(): Int {
        return exception.hashCode()
    }
}
