/*
 * BookDetailModule.kt - app
 * Created by iamlordalvarado on 5/27/20 1:35 PM
 * Copyright (c) 2020 . All rights reserved.
 * Last modified 5/27/20 1:35 PM
 */

package com.bitso.challenge.features.detail.di.modules

import com.bitso.challenge.features.detail.domain.usecases.GetBookDetailUseCase
import com.bitso.challenge.features.detail.view.viewmodels.BookDetailViewModel
import org.koin.core.module.Module
import org.koin.dsl.module

object BookDetailModule {
    val module: Module by lazy {
        module {
            factory { GetBookDetailUseCase(booksRepository = get()) }
            factory { BookDetailViewModel(bookDetailUseCase = get()) }
        }
    }
}