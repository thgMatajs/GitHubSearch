package com.gentalhacode.github.presentation.features.search.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.gentalhacode.github.base.state.Result
import com.gentalhacode.github.domain.features.search.interactor.GetRepositoriesUseCase
import com.gentalhacode.github.model.Repository
import com.gentalhacode.github.presentation.extensions.setFailure
import com.gentalhacode.github.presentation.extensions.setLoading
import com.gentalhacode.github.presentation.extensions.setSuccess

/**
 * .:.:.:. Created by @thgMatajs on 17/02/20 .:.:.:.
 */
class SearchViewModel(
    private val getRepositoriesUseCase: GetRepositoriesUseCase
) : ViewModel() {

    private val getRepositoriesLiveData: MutableLiveData<Result<List<Repository>>> =
        MutableLiveData()

    private fun observeGetRepositoriesLiveData(): LiveData<Result<List<Repository>>> =
        getRepositoriesLiveData

    fun searchRepositoriesBy(language: String) {
        getRepositoriesLiveData.setLoading()
        getRepositoriesUseCase.execute("language:$language",
            onNext = { repositories ->
                getRepositoriesLiveData.setSuccess(repositories)
            },
            onError = { error ->
                getRepositoriesLiveData.setFailure(error)
            })
    }

    override fun onCleared() {
        super.onCleared()
        getRepositoriesUseCase.dispose()
    }
}