package com.gentalhacode.github.remote.features.search

import com.gentalhacode.github.data.features.search.repository.SearchRemote
import com.gentalhacode.github.model.Repository
import com.gentalhacode.github.remote.features.search.service.GitHubService
import io.reactivex.Flowable

/**
 * .:.:.:. Created by @thgMatajs on 14/02/20 .:.:.:.
 */
class SearchRemoteImplementation(
    private val service: GitHubService
) : SearchRemote {

    override fun getRepositoriesBy(language: String): Flowable<List<Repository>> {
        return service.getRepositoriesBy(language).map { response ->
            response.repositories
        }
    }
}