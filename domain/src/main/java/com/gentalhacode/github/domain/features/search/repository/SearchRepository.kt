package com.gentalhacode.github.domain.features.search.repository

import io.reactivex.Flowable

/**
 * .:.:.:. Created by @thgMatajs on 11/02/20 .:.:.:.
 */
interface SearchRepository {

    fun getGitHubRepositoriesBy(language: String)
}