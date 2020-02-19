package com.gentalhacode.github.data.features.search.repository

import com.gentalhacode.github.model.ParamsToSearch
import com.gentalhacode.github.model.Repository
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Single

/**
 * .:.:.:. Created by @thgMatajs on 12/02/20 .:.:.:.
 */
interface SearchCache {
    fun save(repositories: List<Repository>): Completable
    fun getRepositoriesBy(params: ParamsToSearch): Flowable<List<Repository>>
    fun isCached(): Single<Boolean>
}