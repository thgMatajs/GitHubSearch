package com.gentalhacode.github.domain.di

import com.gentalhacode.github.domain.features.search.interactor.GetRepositoriesUseCase
import org.koin.dsl.module

/**
 * .:.:.:. Created by @thgMatajs on 12/02/20 .:.:.:.
 */
val domainModule = module(override = true) {
    factory { GetRepositoriesUseCase(get(), get()) }
}