/*
 * AppDatabase.kt - app
 * Created by iamlordalvarado on 5/26/20 6:50 PM
 * Copyright (c) 2020 . All rights reserved.
 * Last modified 5/26/20 6:50 PM
 */

package com.bitso.challenge.features.list.data.stores.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.bitso.challenge.features.list.data.stores.local.converters.DateConverter
import com.bitso.challenge.features.list.data.stores.local.models.BookEntity
import com.bitso.challenge.features.list.data.stores.local.models.TickerEntity


@Database(
    entities = [
        BookEntity::class,
        TickerEntity::class
    ], version = 1, exportSchema = false
)
@TypeConverters(
    DateConverter::class
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun booksDao(): BooksDao

    companion object {
        private var INSTANCE: AppDatabase? = null

        fun instance(context: Context): AppDatabase {
            if (INSTANCE == null) {
                INSTANCE =
                    Room.databaseBuilder(context, AppDatabase::class.java, "Bitso.db")
                        .fallbackToDestructiveMigration()
                        .build()
            }
            return INSTANCE as AppDatabase
        }
    }
}