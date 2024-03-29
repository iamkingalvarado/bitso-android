/*
 * App.kt - app
 * Created by iamlordalvarado on 5/26/20 4:00 PM
 * Copyright (c) 2020 . All rights reserved.
 * Last modified 5/26/20 4:00 PM
 */

package com.bitso.challenge

import android.app.Application
import com.bitso.challenge.features.detail.di.modules.BookDetailModule
import com.bitso.challenge.features.list.di.modules.AvailableBooksModule
import com.bitso.challenge.features.splash.di.modules.SplashModule
import com.bitso.challenge.network.di.modules.NetworkModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.loadKoinModules
import org.koin.core.context.startKoin

@Suppress("unused")
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
            arrayListOf(
                NetworkModule.module(BuildConfig.API_URL, BuildConfig.DEBUG),
                SplashModule.module,
                AvailableBooksModule.module,
                BookDetailModule.module
            )
        )
    }
}