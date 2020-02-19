package com.gentalhacode.github.remote.features.search

import com.gentalhacode.github.data.features.search.repository.SearchRemote
import com.gentalhacode.github.model.ParamsToSearch
import com.gentalhacode.github.model.Repository
import com.gentalhacode.github.remote.features.search.model.toRemote
import com.gentalhacode.github.remote.features.search.service.GitHubService
import io.reactivex.Flowable

/**
 * .:.:.:. Created by @thgMatajs on 14/02/20 .:.:.:.
 */
class SearchRemoteImplementation(
    private val service: GitHubService
) : SearchRemote {

    override fun getRepositoriesBy(params: ParamsToSearch): Flowable<List<Repository>> {
        val remoteParams = params.toRemote()
        return service.getRepositoriesBy(
            query = remoteParams.language,
            order = remoteParams.order,
            sort = remoteParams.sort,
            page = remoteParams.page
        ).map { response ->
            response.repositories
        }
    }
}