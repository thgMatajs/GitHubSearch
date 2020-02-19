package com.gentalhacode.github.presentation.features.search.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import androidx.paging.RxPagedListBuilder
import com.gentalhacode.github.base.state.Result
import com.gentalhacode.github.domain.features.search.interactor.GetRepositoriesUseCase
import com.gentalhacode.github.model.ParamsToSearch
import com.gentalhacode.github.model.Repository
import com.gentalhacode.github.presentation.extensions.setFailure
import com.gentalhacode.github.presentation.extensions.setLoading
import com.gentalhacode.github.presentation.extensions.setSuccess
import com.gentalhacode.github.presentation.features.search.pagging.SearchRepositoriesSourceFactory
import io.reactivex.BackpressureStrategy
import io.reactivex.Flowable
import io.reactivex.Observable
import io.reactivex.Scheduler
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit

/**
 * .:.:.:. Created by @thgMatajs on 17/02/20 .:.:.:.
 */
class SearchViewModel(
    private val useCase: GetRepositoriesUseCase
) : ViewModel() {

    private lateinit var flowable: Flowable<PagedList<Repository>>
    private val pagedListConfig: PagedList.Config = PagedList.Config.Builder()
        .setPrefetchDistance(20)
        .setEnablePlaceholders(false)
        .build()

    private lateinit var sourceFactory: SearchRepositoriesSourceFactory
    private var dispose: CompositeDisposable = CompositeDisposable()

    private val getRepositoriesLiveData: MutableLiveData<Result<PagedList<Repository>>> =
        MutableLiveData()

    fun observeGetRepositoriesLiveData(): LiveData<Result<PagedList<Repository>>> =
        getRepositoriesLiveData

    fun searchRepositoriesBy(params: ParamsToSearch) {
        getRepositoriesLiveData.setLoading()
        sourceFactory = SearchRepositoriesSourceFactory(params, useCase)
        //todo(Alterar para LiveData)
        flowable = RxPagedListBuilder(sourceFactory, pagedListConfig)
            .setFetchScheduler(Schedulers.trampoline())
            .buildFlowable(BackpressureStrategy.BUFFER)
        dispose.addAll(
            flowable
                .delay(3000, TimeUnit.MILLISECONDS)
                .subscribe(
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
        if (this::flowable.isInitialized) dispose.dispose()
        useCase.dispose()
    }
}