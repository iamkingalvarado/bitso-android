/*
 * NetworkModule.kt - app
 * Created by iamlordalvarado on 5/26/20 6:08 PM
 * Copyright (c) 2020 . All rights reserved.
 * Last modified 5/26/20 6:08 PM
 */

package com.bitso.challenge.network.di.modules

import com.bitso.challenge.network.converters.DateTimeConverter
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.core.module.Module
import org.koin.dsl.module
import org.threeten.bp.OffsetDateTime
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.lang.reflect.Type
import java.util.concurrent.TimeUnit

object NetworkModule {

    private var isDebugMode: Boolean = false
    private lateinit var apiUrl: String

    private val module: Module by lazy {
        module {
            single { provideRetrofit(gson = provideGson()) }
        }
    }

    private fun provideGson(): Gson {
        val type: Type = object : TypeToken<OffsetDateTime?>() {}.type
        return GsonBuilder()
            .registerTypeAdapter(type, DateTimeConverter())
            .create()
    }

    fun module(apiUrl: String, isDebugMode: Boolean): Module {
        this.apiUrl = apiUrl
        this.isDebugMode = isDebugMode
        return module
    }

    private fun provideRetrofit(gson: Gson): Retrofit {
        val builder = Retrofit.Builder()
            .baseUrl(apiUrl)
            .addConverterFactory(GsonConverterFactory.create(gson))
        builder.client(client())
        return builder.build()
    }

    private fun client(): OkHttpClient {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        var clientBuilder = if (isDebugMode) {
            OkHttpClient.Builder()
                .addInterceptor(interceptor)
        } else {
            OkHttpClient.Builder()
        }
        clientBuilder = clientBuilder
            .connectTimeout(60, TimeUnit.SECONDS)
            .callTimeout(60, TimeUnit.SECONDS)
            .writeTimeout(60, TimeUnit.SECONDS)
        return clientBuilder.build()
    }
}
