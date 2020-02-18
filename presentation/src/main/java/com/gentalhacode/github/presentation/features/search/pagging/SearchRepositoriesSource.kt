package com.gentalhacode.github.presentation.features.search.pagging

import androidx.paging.PageKeyedDataSource
import com.gentalhacode.github.domain.features.search.interactor.GetRepositoriesUseCase
import com.gentalhacode.github.model.Repository
import io.reactivex.Observable

/**
 * .:.:.:. Created by @thgMatajs on 17/02/20 .:.:.:.
 */
class SearchRepositoriesSource(
    private val language: String,
    private val useCase: GetRepositoriesUseCase
) : PageKeyedDataSource<Int, Repository>() {

    override fun loadInitial(
        params: LoadInitialParams<Int>,
        callback: LoadInitialCallback<Int, Repository>
    ) {
        createObservable(1, 2, params.requestedLoadSize, callback, null)
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, Repository>) {
        createObservable(params.key, params.key + 1, params.requestedLoadSize, null, callback)
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, Repository>) {
        createObservable(params.key, params.key - 1, params.requestedLoadSize, null, callback)
    }

    private fun createObservable(
        requestedPage: Int,
        adjacentPage: Int,
        requestedLoadSize: Int,
        initialCallback: LoadInitialCallback<Int, Repository>?,
        callback: LoadCallback<Int, Repository>?
    ) {
        useCase.execute("language:$language",
            onNext = { repositories ->
                initialCallback?.onResult(repositories, null, adjacentPage)
                callback?.onResult(repositories, adjacentPage)
            },
            onError = { error ->
                Observable.error<Exception>(error)
            })
    }
}