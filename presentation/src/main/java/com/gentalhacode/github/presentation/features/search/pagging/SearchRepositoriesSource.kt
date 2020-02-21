package com.gentalhacode.github.presentation.features.search.pagging

import androidx.paging.PageKeyedDataSource
import com.gentalhacode.github.domain.features.search.interactor.GetRepositoriesUseCase
import com.gentalhacode.github.model.ParamsToSearch
import com.gentalhacode.github.model.Repository
import io.reactivex.Flowable

/**
 * .:.:.:. Created by @thgMatajs on 17/02/20 .:.:.:.
 */
class SearchRepositoriesSource(
    private val paramsToSearch: ParamsToSearch,
    private val useCase: GetRepositoriesUseCase
) : PageKeyedDataSource<Int, Repository>() {

    override fun loadInitial(
        params: LoadInitialParams<Int>,
        callback: LoadInitialCallback<Int, Repository>
    ) {
        createObservable(1, 2, callback, null)
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, Repository>) {
        createObservable(params.key, params.key + 1, null, callback)
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, Repository>) {
        createObservable(params.key, params.key - 1, null, callback)
    }

    private fun createObservable(
        requestedPage: Int,
        adjacentPage: Int,
        initialCallback: LoadInitialCallback<Int, Repository>?,
        callback: LoadCallback<Int, Repository>?
    ) {
        paramsToSearch.page = requestedPage
        useCase.execute(paramsToSearch,
            onNext = { repositories ->
                initialCallback?.onResult(repositories, null, adjacentPage)
                callback?.onResult(repositories, adjacentPage)
                println("THG_LOG --> SOURCE ON_NEXT ${repositories.size}")
            },
            onError = { error ->
                Flowable.error<Throwable>(error)
                println("THG_LOG --> SOURCE ON_ERROR $error")
            })
    }
}