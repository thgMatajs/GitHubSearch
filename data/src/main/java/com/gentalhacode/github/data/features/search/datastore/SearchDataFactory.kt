package com.gentalhacode.github.data.features.search.datastore

/**
 * .:.:.:. Created by @thgMatajs on 12/02/20 .:.:.:.
 */
class SearchDataFactory(
    private val remote: SearchRemoteDataStore,
    private val cache: SearchCacheDataStore
) {

    fun getRemote() = remote
    fun getCache() = cache
}