package com.gentalhacode.github.data.features.search.repository

import com.gentalhacode.github.model.ParamsToSearch
import com.gentalhacode.github.model.Repository
import io.reactivex.Flowable

/**
 * .:.:.:. Created by @thgMatajs on 12/02/20 .:.:.:.
 */
interface SearchRemote {
    fun getRepositoriesBy(params: ParamsToSearch): Flowable<List<Repository>>
}