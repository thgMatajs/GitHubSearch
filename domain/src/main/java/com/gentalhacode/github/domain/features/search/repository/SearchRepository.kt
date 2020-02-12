package com.gentalhacode.github.domain.features.search.repository

import com.gentalhacode.github.model.Repository
import io.reactivex.Flowable

/**
 * .:.:.:. Created by @thgMatajs on 11/02/20 .:.:.:.
 */
interface SearchRepository {
    fun getRepositoriesBy(language: String): Flowable<Repository>
}