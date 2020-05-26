/*
 * SplashActivity.kt - app
 * Created by iamlordalvarado on 5/26/20 3:43 PM
 * Copyright (c) 2020 . All rights reserved.
 * Last modified 5/26/20 3:43 PM
 */

package com.bitso.challenge.features.splash.view.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bitso.challenge.R
import com.bitso.challenge.features.list.view.activities.AvailableBooksActivity
import com.bitso.challenge.features.splash.view.viewmodels.SplashViewModel
import com.bitso.challenge.features.splash.view.views.SplashView
import com.bitso.challenge.ui.extensions.showAsRoot
import org.koin.androidx.viewmodel.ext.android.viewModel

class SplashActivity : AppCompatActivity(), SplashView {

    private val splashViewModel: SplashViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        splashViewModel.setView(view = this)
        splashViewModel.checkWhereToNavigate()
    }

    override fun navigateToAvailableBooks() {
        showAsRoot<AvailableBooksActivity>()
    }
}