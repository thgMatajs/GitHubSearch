package com.gentalhacode.github.application

import android.app.Application
import com.gentalhacode.github.di.allModules
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

/**
 * .:.:.:. Created by @thgMatajs on 17/02/20 .:.:.:.
 */
class GitHubApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        setupKoin()
    }

    private fun setupKoin() {
        startKoin {
            androidContext(this@GitHubApplication)
            androidLogger()
            allModules
        }
    }
}