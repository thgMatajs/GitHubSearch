package com.gentalhacode.github.cache.features.search

import com.gentalhacode.github.cache.features.search.database.GitHubDatabase
import com.gentalhacode.github.cache.features.search.entities.toChache
import com.gentalhacode.github.data.features.search.repository.SearchCache
import com.gentalhacode.github.model.ParamsToSearch
import com.gentalhacode.github.model.Repository
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Single

/**
 * .:.:.:. Created by @thgMatajs on 19/02/20 .:.:.:.
 */
class SearchCacheImplementation(
    private val gitHubDatabase: GitHubDatabase
) : SearchCache {

    override fun save(repositories: List<Repository>): Completable {
        return gitHubDatabase.repositoryDao().insert(repositories.map { it.toChache() })
    }

    override fun getRepositoriesBy(params: ParamsToSearch): Flowable<List<Repository>> {
        return gitHubDatabase.repositoryDao().getRepositoriesBy().map {
            it.map { repo -> repo as Repository }
        }
    }

    override fun isCached(): Single<Boolean> {
        return Single.just(false)
    }
}