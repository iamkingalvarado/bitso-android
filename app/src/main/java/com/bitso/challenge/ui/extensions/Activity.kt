/*
 * Activity.kt - app
 * Created by iamlordalvarado on 5/26/20 3:58 PM
 * Copyright (c) 2020 . All rights reserved.
 * Last modified 5/26/20 3:58 PM
 */

package com.bitso.challenge.ui.extensions

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity

inline fun <reified T : AppCompatActivity> AppCompatActivity.showAsRoot() {
    startActivity(Intent(this, T::class.java).apply {
        flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
    })
    finishAndRemoveTask()
}