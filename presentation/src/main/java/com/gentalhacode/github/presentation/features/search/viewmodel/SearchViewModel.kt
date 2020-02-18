package com.gentalhacode.github.presentation.features.search.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import androidx.paging.RxPagedListBuilder
import com.gentalhacode.github.base.state.Result
import com.gentalhacode.github.domain.features.search.interactor.GetRepositoriesUseCase
import com.gentalhacode.github.model.Repository
import com.gentalhacode.github.presentation.extensions.setFailure
import com.gentalhacode.github.presentation.extensions.setLoading
import com.gentalhacode.github.presentation.extensions.setSuccess
import com.gentalhacode.github.presentation.features.search.pagging.SearchRepositoriesSourceFactory
import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

/**
 * .:.:.:. Created by @thgMatajs on 17/02/20 .:.:.:.
 */
class SearchViewModel(
    private val useCase: GetRepositoriesUseCase
) : ViewModel() {

    lateinit var observable: Observable<PagedList<Repository>>
    private val pagedListConfig: PagedList.Config = PagedList.Config.Builder()
        .setPrefetchDistance(6)
        .setEnablePlaceholders(false)
        .build()
    private lateinit var sourceFactory: SearchRepositoriesSourceFactory
    private var dispose: CompositeDisposable = CompositeDisposable()

    private val getRepositoriesLiveData: MutableLiveData<Result<PagedList<Repository>>> =
        MutableLiveData()

    fun observeGetRepositoriesLiveData(): LiveData<Result<PagedList<Repository>>> =
        getRepositoriesLiveData

    fun searchRepositoriesBy(language: String) {
        getRepositoriesLiveData.setLoading()
        sourceFactory = SearchRepositoriesSourceFactory(language, useCase)
        observable = RxPagedListBuilder(sourceFactory, pagedListConfig)
            .setFetchScheduler(Schedulers.io())
            .buildObservable()
        dispose.add(
            observable.subscribe(
                { repositories ->
                    getRepositoriesLiveData.setSuccess(repositories)
                },
                { error ->
                    getRepositoriesLiveData.setFailure(error)
                }
            ))
    }

    override fun onCleared() {
        super.onCleared()
        if (this::sourceFactory.isInitialized) sourceFactory.dispose()
        if (this::observable.isInitialized) dispose.dispose()
    }
}