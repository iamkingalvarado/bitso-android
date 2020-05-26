/*
 * App.kt - app
 * Created by iamlordalvarado on 5/26/20 4:00 PM
 * Copyright (c) 2020 . All rights reserved.
 * Last modified 5/26/20 4:00 PM
 */

package com.bitso.challenge

import android.app.Application
import com.bitso.challenge.features.splash.di.modules.SplashModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.loadKoinModules
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        initInjection()
    }

    private fun initInjection() {
        startKoin {
            printLogger()
            androidContext(this@App)
        }

        loadKoinModules(
            SplashModule.module
        )
    }
}