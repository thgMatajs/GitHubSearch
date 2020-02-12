package com.gentalhacode.github.base.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * .:.:.:. Created by @thgMatajs on 11/02/20 .:.:.:.
 */
class ServiceBuilder {
    inline operator fun <reified S> invoke(baseUrl: String, isDebugging: Boolean): S {
        val httpClient = buildInterceptors(isDebugging)
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(httpClient)
            .build()
            .create(S::class.java)
    }

    fun buildInterceptors(isDebugging: Boolean): OkHttpClient {
        val loggerInterceptor = getLoggerInterceptor(isDebugging)
        return OkHttpClient.Builder().apply {
            connectTimeout(60, TimeUnit.SECONDS)
            readTimeout(60, TimeUnit.SECONDS)
            addInterceptor(loggerInterceptor)
        }.build()
    }

    private fun getLoggerInterceptor(isDebugging: Boolean): HttpLoggingInterceptor {
        val level = if (isDebugging)
            HttpLoggingInterceptor.Level.BODY
        else
            HttpLoggingInterceptor.Level.NONE
        return HttpLoggingInterceptor().apply { this.level = level }
    }
}