package com.gentalhacode.github.data.di

import com.gentalhacode.github.data.features.search.SearchRepositoryImplementation
import com.gentalhacode.github.data.features.search.datastore.SearchCacheDataStore
import com.gentalhacode.github.data.features.search.datastore.SearchDataFactory
import com.gentalhacode.github.data.features.search.datastore.SearchRemoteDataStore
import com.gentalhacode.github.domain.features.search.repository.SearchRepository
import org.koin.dsl.module

/**
 * .:.:.:. Created by @thgMatajs on 13/02/20 .:.:.:.
 */
val dataModule = module {
    factory { SearchCacheDataStore(get()) }
    factory { SearchRemoteDataStore(get()) }
    factory { SearchDataFactory(get()) }
    factory<SearchRepository> { SearchRepositoryImplementation(get()) }
}