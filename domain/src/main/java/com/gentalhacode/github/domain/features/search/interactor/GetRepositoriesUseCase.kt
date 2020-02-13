package com.gentalhacode.github.domain.features.search.interactor

import com.gentalhacode.github.base.rx.FlowableUseCase
import com.gentalhacode.github.base.rx.PostExecutionThread
import com.gentalhacode.github.domain.features.search.repository.SearchRepository
import com.gentalhacode.github.model.Repository
import io.reactivex.Flowable

/**
 * .:.:.:. Created by @thgMatajs on 11/02/20 .:.:.:.
 */
class GetRepositoriesUseCase(
    private val repository: SearchRepository,
    postExecutionThread: PostExecutionThread
) : FlowableUseCase<String, List<Repository>>(postExecutionThread) {

    override fun buildUseCaseFlowable(params: String?): Flowable<List<Repository>> {
        return params?.let { language ->
            repository.getRepositoriesBy(language).takeIf { language.isNotBlank() }
                ?: Flowable.error(IllegalArgumentException("Parameter can not be blank"))
        } ?: Flowable.error(IllegalArgumentException("Parameter can not be null"))
    }
}