package com.gentalhacode.github.presentation.di

import com.gentalhacode.github.base.rx.PostExecutionThread
import com.gentalhacode.github.presentation.execution.UiThread
import com.gentalhacode.github.presentation.features.search.viewmodel.SearchViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * .:.:.:. Created by @thgMatajs on 17/02/20 .:.:.:.
 */
val presentationModule = module {
    single<PostExecutionThread> { UiThread() }
    viewModel { SearchViewModel(get()) }
}