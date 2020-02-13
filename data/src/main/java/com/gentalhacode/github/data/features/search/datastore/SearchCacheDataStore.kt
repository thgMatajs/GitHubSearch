package com.gentalhacode.github.data.features.search.datastore

import com.gentalhacode.github.data.features.search.repository.SearchCache
import com.gentalhacode.github.data.features.search.repository.SearchDataStore
import com.gentalhacode.github.model.Repository
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Single

/**
 * .:.:.:. Created by @thgMatajs on 12/02/20 .:.:.:.
 */
class SearchCacheDataStore(
    private val cache: SearchCache
) : SearchDataStore.Cache {

    override fun save(repositories: List<Repository>): Completable {
        return cache.save(repositories)
    }

    override fun getRepositoriesBy(language: String): Flowable<List<Repository>> {
        return cache.getRepositoriesBy(language)
    }

    override fun isCached(): Single<Boolean> {
        return cache.isCached()
    }
}