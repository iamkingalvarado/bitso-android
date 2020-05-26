/*
 * Mapper.kt - app
 * Created by iamlordalvarado on 5/26/20 4:21 PM
 * Copyright (c) 2020 . All rights reserved.
 * Last modified 5/26/20 4:21 PM
 */

package com.bitso.challenge.core.mapping

abstract class Mapper<T, R> {

    abstract fun map(from: T): R

    fun mapList(from: List<T>): List<R> {
        return from.map { map(it) }
    }
}
