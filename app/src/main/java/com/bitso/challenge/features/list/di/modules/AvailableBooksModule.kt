/*
 * AvailableBooksModule.kt - app
 * Created by iamlordalvarado on 5/26/20 4:50 PM
 * Copyright (c) 2020 . All rights reserved.
 * Last modified 5/26/20 4:50 PM
 */

package com.bitso.challenge.features.list.di.modules

import com.bitso.challenge.features.list.domain.usecases.GetAvailableBooksUseCase
import com.bitso.challenge.features.list.view.viewmodels.AvailableBooksViewModel
import org.koin.core.module.Module
import org.koin.dsl.module

object AvailableBooksModule {

    val module: Module by lazy {
        module {
            factory { GetAvailableBooksUseCase() }
            factory { AvailableBooksViewModel(useCase = get()) }
        }
    }
}