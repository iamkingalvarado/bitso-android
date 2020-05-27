/*
 * DateTimeConverter.kt - app
 * Created by iamlordalvarado on 5/26/20 9:51 PM
 * Copyright (c) 2020 . All rights reserved.
 * Last modified 5/26/20 9:51 PM
 */

package com.bitso.challenge.network.converters

import com.google.gson.*
import org.threeten.bp.OffsetDateTime
import org.threeten.bp.format.DateTimeFormatter
import java.lang.reflect.Type

class DateTimeConverter : JsonSerializer<OffsetDateTime>, JsonDeserializer<OffsetDateTime> {

    private val formatter: DateTimeFormatter = DateTimeFormatter.ISO_OFFSET_DATE_TIME

    override fun serialize(
        src: OffsetDateTime?,
        typeOfSrc: Type?,
        context: JsonSerializationContext?
    ): JsonElement {
        return JsonPrimitive(formatter.format(src))
    }

    override fun deserialize(
        json: JsonElement?,
        typeOfT: Type?,
        context: JsonDeserializationContext?
    ): OffsetDateTime {
        return formatter.parse(json?.asString, OffsetDateTime::from)
    }

}
