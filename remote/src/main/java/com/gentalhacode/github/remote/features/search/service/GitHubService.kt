package com.gentalhacode.github.remote.features.search.service

import com.gentalhacode.github.remote.features.search.model.GitHubResponse
import io.reactivex.Flowable
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * .:.:.:. Created by @thgMatajs on 14/02/20 .:.:.:.
 */
interface GitHubService {

    @GET("search/repositories")
    fun getRepositoriesBy(
        @Query("q") query: String,
        @Query("sort") sort: String,
        @Query("order") order: String,
        @Query("page") page: Int
    ): Flowable<GitHubResponse>
}