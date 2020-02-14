package com.gentalhacode.github.remote.features.factory

import com.gentalhacode.github.base.random.randomInt
import com.gentalhacode.github.base.random.randomLong
import com.gentalhacode.github.base.random.randomString
import com.gentalhacode.github.data.features.search.model.DataOwner
import com.gentalhacode.github.data.features.search.model.DataRepository
import com.gentalhacode.github.model.Repository
import com.gentalhacode.github.remote.features.search.model.GitHubResponse
import com.gentalhacode.github.remote.features.search.service.GitHubService

/**
 * .:.:.:. Created by @thgMatajs on 13/02/20 .:.:.:.
 */
object RemoteFactory {

    fun dummyGitHubResponse() = GitHubResponse(
        dummyRemoteRepositories()
    )

    private fun dummyRemoteRepositories(): List<Repository> = listOf(
        dummyRemoteRepository(),
        dummyRemoteRepository(),
        dummyRemoteRepository(),
        dummyRemoteRepository(),
        dummyRemoteRepository(),
        dummyRemoteRepository()
    )

    private fun dummyRemoteRepository() = DataRepository(
        name = randomString(),
        totalForks = randomInt(),
        totalStars = randomInt(),
        id = randomLong(),
        owner = dummyRemoteOwner()
    )

    private fun dummyRemoteOwner() = DataOwner(
        name = randomString(),
        urlPhoto = randomString()
    )
}