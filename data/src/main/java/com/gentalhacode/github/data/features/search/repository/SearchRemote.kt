package com.gentalhacode.github.data.features.search.repository

import com.gentalhacode.github.model.Repository
import io.reactivex.Flowable

/**
 * .:.:.:. Created by @thgMatajs on 12/02/20 .:.:.:.
 */
interface SearchRemote {
    fun getRepositoriesBy(language: String): Flowable<List<Repository>>
}