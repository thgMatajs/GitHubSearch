package com.gentalhacode.github.data.features.search.datastore

import com.gentalhacode.github.data.features.search.repository.SearchDataStore
import com.gentalhacode.github.data.features.search.repository.SearchRemote
import com.gentalhacode.github.model.Repository
import io.reactivex.Flowable

/**
 * .:.:.:. Created by @thgMatajs on 12/02/20 .:.:.:.
 */
open class SearchRemoteDataStore(
    private val remote: SearchRemote
) : SearchDataStore.Remote {

    override fun getRepositoriesBy(language: String): Flowable<List<Repository>> {
        return remote.getRepositoriesBy(language)
    }
}