/*
 * AvailableBooksModule.kt - app
 * Created by iamlordalvarado on 5/26/20 4:50 PM
 * Copyright (c) 2020 . All rights reserved.
 * Last modified 5/26/20 4:50 PM
 */

package com.bitso.challenge.features.list.di.modules

import com.bitso.challenge.features.list.data.repositories.DefaultBooksRepository
import com.bitso.challenge.features.list.data.stores.RemoteBooksStore
import com.bitso.challenge.features.list.data.stores.RoomBooksStore
import com.bitso.challenge.features.list.data.stores.api.BitsoApi
import com.bitso.challenge.features.list.data.stores.local.AppDatabase
import com.bitso.challenge.features.list.data.stores.local.BooksDao
import com.bitso.challenge.features.list.domain.repositories.BooksRepository
import com.bitso.challenge.features.list.domain.stores.BooksStore
import com.bitso.challenge.features.list.domain.usecases.GetAvailableBooksUseCase
import com.bitso.challenge.features.list.view.viewmodels.AvailableBooksViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.core.module.Module
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit

object AvailableBooksModule {

    private const val LOCAL_BOOK_STORE = "LOCAL_BOOK_STORE"
    private const val REMOTE_BOOK_STORE = "REMOTE_BOOK_STORE"

    val module: Module by lazy {
        module {
            single { AppDatabase.instance(context = androidContext()) }

            // Dao
            factory<BooksStore>(named(LOCAL_BOOK_STORE)) {
                RoomBooksStore(
                    booksDao = provideBooksDao(database = get())
                )
            }

            // Remote
            factory<BooksStore>(named(REMOTE_BOOK_STORE)) {
                RemoteBooksStore(
                    bitsoApi = provideApi(
                        retrofit = get()
                    )
                )
            }

            factory<BooksRepository> {
                DefaultBooksRepository(
                    localStore = get(named(LOCAL_BOOK_STORE)),
                    remoteStore = get(named(REMOTE_BOOK_STORE))
                )
            }
            factory { GetAvailableBooksUseCase(booksRepository = get()) }
            factory { AvailableBooksViewModel(useCase = get()) }
        }
    }

    private fun provideApi(retrofit: Retrofit): BitsoApi {
        return retrofit.create(BitsoApi::class.java)
    }

    private fun provideBooksDao(database: AppDatabase): BooksDao {
        return database.booksDao()
    }
}