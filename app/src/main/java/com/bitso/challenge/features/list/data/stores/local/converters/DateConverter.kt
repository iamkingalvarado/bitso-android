/*
 * DateConverter.kt - app
 * Created by iamlordalvarado on 5/26/20 6:51 PM
 * Copyright (c) 2020 . All rights reserved.
 * Last modified 5/26/20 6:51 PM
 */

package com.bitso.challenge.features.list.data.stores.local.converters

import androidx.room.TypeConverter
import org.threeten.bp.OffsetDateTime
import org.threeten.bp.format.DateTimeFormatter

object DateConverter {
    private val formatter = DateTimeFormatter.ISO_OFFSET_DATE_TIME

    @TypeConverter
    @JvmStatic
    fun toOffsetDateTime(value: String?): OffsetDateTime? {
        return value?.let {
            return formatter.parse(value, OffsetDateTime::from)
        }
    }

    @TypeConverter
    @JvmStatic
    fun fromOffsetDateTime(date: OffsetDateTime?): String? {
        return date?.format(formatter)
    }
}
