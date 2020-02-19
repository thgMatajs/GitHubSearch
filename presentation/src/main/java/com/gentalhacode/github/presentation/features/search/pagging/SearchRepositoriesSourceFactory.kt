package com.gentalhacode.github.presentation.features.search.pagging

import androidx.paging.DataSource
import com.gentalhacode.github.domain.features.search.interactor.GetRepositoriesUseCase
import com.gentalhacode.github.model.ParamsToSearch
import com.gentalhacode.github.model.Repository


/**
 * .:.:.:. Created by @thgMatajs on 17/02/20 .:.:.:.
 */
class SearchRepositoriesSourceFactory(
    private val params: ParamsToSearch,
    private val useCase: GetRepositoriesUseCase
) : DataSource.Factory<Int, Repository>() {

    override fun create(): DataSource<Int, Repository> {
        return SearchRepositoriesSource(params, useCase)
    }

    fun dispose() {
        useCase.dispose()
    }
}