package com.gentalhacode.domain.features.search.interactor

import com.gentalhacode.domain.features.factory.RepositoryFactory
import com.gentalhacode.github.base.rx.PostExecutionThread
import com.gentalhacode.github.domain.features.search.interactor.GetRepositoriesUseCase
import com.gentalhacode.github.domain.features.search.model.DomainParamsToSearch
import com.gentalhacode.github.domain.features.search.repository.SearchRepository
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import io.reactivex.Flowable
import org.junit.Before
import org.junit.Test

/**
 * .:.:.:. Created by @thgMatajs on 12/02/20 .:.:.:.
 */
class GetRepositoriesUseCaseTest {

    private lateinit var useCase: GetRepositoriesUseCase
    private val repository = mock<SearchRepository>()
    private var postExecutionThread = mock<PostExecutionThread>()
    private val dummyRepositories = RepositoryFactory.dummyDomainRepositories()
    private val paramsToSearch = RepositoryFactory.dummyDomainParamsToSearch()

    @Before
    fun init() {
        useCase = GetRepositoriesUseCase(repository, postExecutionThread)
        whenever(repository.getRepositoriesBy(paramsToSearch))
            .thenReturn(Flowable.just(dummyRepositories))
    }

    @Test
    fun `Check if Repositories is loaded`() {
        val call = useCase.buildUseCaseFlowable(paramsToSearch).test()

        call.assertValue {
            it.size == dummyRepositories.size
        }
            .assertNoErrors()
            .assertComplete()
    }

    @Test
    fun `Check exception when pass null param`() {
        val call = useCase.buildUseCaseFlowable().test()
        call.assertFailure(IllegalArgumentException::class.java)
    }

    @Test
    fun `Check exception when pass blank param`() {
        val params = DomainParamsToSearch("")
        whenever(repository.getRepositoriesBy(params))
            .thenReturn(Flowable.just(dummyRepositories))
        val call = useCase.buildUseCaseFlowable(params).test()
        call.assertFailure(IllegalArgumentException::class.java)
    }
}