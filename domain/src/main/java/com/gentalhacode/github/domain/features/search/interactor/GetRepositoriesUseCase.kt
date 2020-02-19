package com.gentalhacode.github.domain.features.search.interactor

import com.gentalhacode.github.base.rx.FlowableUseCase
import com.gentalhacode.github.base.rx.PostExecutionThread
import com.gentalhacode.github.domain.features.search.repository.SearchRepository
import com.gentalhacode.github.model.ParamsToSearch
import com.gentalhacode.github.model.Repository
import io.reactivex.Flowable

/**
 * .:.:.:. Created by @thgMatajs on 11/02/20 .:.:.:.
 */
class GetRepositoriesUseCase(
    private val repository: SearchRepository,
    postExecutionThread: PostExecutionThread
) : FlowableUseCase<ParamsToSearch, List<Repository>>(postExecutionThread) {

    override fun buildUseCaseFlowable(params: ParamsToSearch?): Flowable<List<Repository>> {
        return params?.let { paramsToSearch ->
            repository.getRepositoriesBy(paramsToSearch).takeIf { paramsToSearch.language.isBlank() }
                ?: Flowable.error(IllegalArgumentException("Parameter can not be blank"))
        } ?: Flowable.error(IllegalArgumentException("Parameter can not be null"))
    }
}