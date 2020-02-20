package com.gentalhacode.github.di

import com.gentalhacode.github.cache.di.cacheModule
import com.gentalhacode.github.data.di.dataModule
import com.gentalhacode.github.domain.di.domainModule
import com.gentalhacode.github.presentation.di.presentationModule
import com.gentalhacode.github.remote.di.remoteModule
import org.koin.core.context.loadKoinModules

/**
 * .:.:.:. Created by @thgMatajs on 17/02/20 .:.:.:.
 */
val allModules = loadKoinModules(
    listOf(
        domainModule,
        dataModule,
        remoteModule,
        cacheModule,
        presentationModule
    )
)