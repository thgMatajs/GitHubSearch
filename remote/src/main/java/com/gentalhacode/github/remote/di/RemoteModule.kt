package com.gentalhacode.github.remote.di

import com.gentalhacode.github.base.network.ServiceBuilder
import com.gentalhacode.github.data.features.search.repository.SearchRemote
import com.gentalhacode.github.remote.features.search.SearchRemoteImplementation
import com.gentalhacode.github.remote.features.search.service.GitHubService
import org.koin.dsl.module

/**
 * .:.:.:. Created by @thgMatajs on 14/02/20 .:.:.:.
 */
val remoteModule = module {
    factory {
        ServiceBuilder().invoke<GitHubService>("https://api.github.com/", true)
    }
    factory<SearchRemote> { SearchRemoteImplementation(get()) }
}