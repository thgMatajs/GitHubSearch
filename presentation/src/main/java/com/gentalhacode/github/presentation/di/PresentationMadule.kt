package com.gentalhacode.github.presentation.di

import com.gentalhacode.github.presentation.features.search.viewmodel.SearchViewModel
import org.koin.dsl.module

/**
 * .:.:.:. Created by @thgMatajs on 17/02/20 .:.:.:.
 */
val presentationModule = module {
    factory { SearchViewModel(get()) }
}