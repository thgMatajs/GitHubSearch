package com.gentalhacode.github.data.features

import com.gentalhacode.github.base.random.randomBoolean
import com.gentalhacode.github.data.factory.DataFactory
import com.gentalhacode.github.data.features.search.SearchRepositoryImplementation
import com.gentalhacode.github.data.features.search.datastore.SearchCacheDataStore
import com.gentalhacode.github.data.features.search.datastore.SearchDataFactory
import com.gentalhacode.github.data.features.search.datastore.SearchRemoteDataStore
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Single
import org.junit.Before
import org.junit.Test

/**
 * .:.:.:. Created by @thgMatajs on 13/02/20 .:.:.:.
 */
class SearchRepositoryImplementationTest {

    private val remoteDataStore: SearchRemoteDataStore = mock()
    private val cacheDataStore: SearchCacheDataStore = mock()
    private val dataFactory = SearchDataFactory(remoteDataStore, cacheDataStore)
    private val repositoryImpl = SearchRepositoryImplementation(dataFactory)
    private val isCached = randomBoolean()
    private val dummyDataRepositories = DataFactory.dummyDataRepositories()
    private val language = "kotlin"

    @Before
    fun init() {
        whenever(cacheDataStore.isCached())
            .thenReturn(Single.just(isCached))
        whenever(cacheDataStore.save(dummyDataRepositories))
            .thenReturn(Completable.complete())
        whenever(cacheDataStore.getRepositoriesBy(language))
            .thenReturn(Flowable.just(dummyDataRepositories))
        whenever(remoteDataStore.getRepositoriesBy(language))
            .thenReturn(Flowable.just(dummyDataRepositories))
    }

    @Test
    fun `Check if return boolean`() {
        val test = cacheDataStore.isCached().test()
        test.assertNoErrors()
            .assertComplete()
            .assertValue(isCached)
    }

    @Test
    fun `Check if the list is save in cache`() {
        val test = cacheDataStore.save(dummyDataRepositories).test()
        test.assertNoErrors()
            .assertComplete()
    }

    @Test
    fun `Check that the cache list is loading`() {
        val test = cacheDataStore.getRepositoriesBy(language).test()
        test.assertNoErrors()
            .assertComplete()
            .assertValue {
                it.size == dummyDataRepositories.size
            }
    }

    @Test
    fun `Check that the remote list is loading`() {
        val test = remoteDataStore.getRepositoriesBy(language).test()
        test.assertNoErrors()
            .assertComplete()
            .assertValue {
                it.size == dummyDataRepositories.size
            }
    }

    @Test
    fun `Check if list is loading data cache`() {
        whenever(cacheDataStore.isCached())
            .thenReturn(Single.just(true))
        val test = repositoryImpl.getRepositoriesBy(language).test()
        test.assertNoErrors()
            .assertComplete()
            .assertValue {
                it.size == dummyDataRepositories.size
            }
    }

    @Test
    fun `Check if list is loading data remote`() {
        whenever(cacheDataStore.isCached())
            .thenReturn(Single.just(false))
        val test = repositoryImpl.getRepositoriesBy(language).test()
        test.assertNoErrors()
            .assertComplete()
            .assertValue {
                it.size == dummyDataRepositories.size
            }
    }

}