/*
 * SplashModule.kt - app
 * Created by iamlordalvarado on 5/26/20 4:02 PM
 * Copyright (c) 2020 . All rights reserved.
 * Last modified 5/26/20 4:02 PM
 */

package com.bitso.challenge.features.splash.di.modules

import com.bitso.challenge.features.splash.view.viewmodels.SplashViewModel
import org.koin.core.module.Module
import org.koin.dsl.module

object SplashModule {

    val module: Module by lazy {
        module {
            factory { SplashViewModel() }
        }
    }
}
