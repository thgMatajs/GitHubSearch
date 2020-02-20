package com.gentalhacode.github.cache.di

import com.gentalhacode.github.cache.features.search.SearchCacheImplementation
import com.gentalhacode.github.cache.features.search.database.GitHubDatabase
import com.gentalhacode.github.data.features.search.repository.SearchCache
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

/**
 * .:.:.:. Created by @thgMatajs on 19/02/20 .:.:.:.
 */
val cacheModule = module {
    factory { GitHubDatabase.getDatabase(androidContext()) }
    factory<SearchCache> { SearchCacheImplementation(get()) }
}