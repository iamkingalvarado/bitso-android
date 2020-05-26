/*
 * SplashViewModel.kt - app
 * Created by iamlordalvarado on 5/26/20 3:54 PM
 * Copyright (c) 2020 . All rights reserved.
 * Last modified 5/26/20 3:54 PM
 */

package com.bitso.challenge.features.splash.view.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bitso.challenge.core.extensions.unwrap
import com.bitso.challenge.features.splash.view.views.SplashView
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.lang.ref.WeakReference


class SplashViewModel : ViewModel() {

    private var view: WeakReference<SplashView>? = null

    fun setView(view: SplashView) {
        this.view = WeakReference(view)
    }

    fun checkWhereToNavigate() {
        viewModelScope.launch {
            delay(800)
            view.unwrap { it.navigateToAvailableBooks() }
        }
    }
}
