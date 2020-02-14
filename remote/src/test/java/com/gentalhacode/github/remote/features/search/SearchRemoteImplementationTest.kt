package com.gentalhacode.github.remote.features.search

import com.gentalhacode.github.data.features.search.repository.SearchRemote
import com.gentalhacode.github.remote.features.factory.RemoteFactory
import com.gentalhacode.github.remote.features.search.service.GitHubService
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import io.reactivex.Flowable
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

/**
 * .:.:.:. Created by @thgMatajs on 14/02/20 .:.:.:.
 */
@RunWith(JUnit4::class)
class SearchRemoteImplementationTest {
    private val service = mock<GitHubService>()
    private val remoteImplementation: SearchRemote = SearchRemoteImplementation(service)

    private val dummyResponse = RemoteFactory.dummyGitHubResponse()
    private val dummyRepositories = dummyResponse.repositories
    private val params = "kotlin"

    @Before
    fun init() {
        whenever(service.getRepositoriesBy(params))
            .thenReturn(Flowable.just(dummyResponse))
    }

    @Test
    fun `Verify call to github response has been completed`() {
        val test = remoteImplementation.getRepositoriesBy(params).test()
        test.assertComplete()
            .assertNoErrors()
    }

    @Test
    fun `Verify sure the call is loading a list of data`() {
        val test = remoteImplementation.getRepositoriesBy(params).test()
        test.awaitTerminalEvent()
        test.assertComplete()
            .assertNoErrors()
            .assertValue {
                it.size == dummyRepositories.size && it == dummyRepositories
            }
    }
}