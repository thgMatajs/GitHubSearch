package com.gentalhacode.domain.features.factory

import com.gentalhacode.github.base.random.randomInt
import com.gentalhacode.github.base.random.randomLong
import com.gentalhacode.github.base.random.randomString
import com.gentalhacode.github.domain.features.search.model.DomainRepository
import com.gentalhacode.github.domain.features.search.model.DomainOwner
import com.gentalhacode.github.domain.features.search.model.DomainParamsToSearch
import com.gentalhacode.github.model.Repository

/**
 * .:.:.:. Created by @thgMatajs on 12/02/20 .:.:.:.
 */
object RepositoryFactory {

    fun dummyDomainRepositories(): List<Repository> = listOf(
        dummyDomainRepository(),
        dummyDomainRepository(),
        dummyDomainRepository(),
        dummyDomainRepository(),
        dummyDomainRepository(),
        dummyDomainRepository()
    )

    private fun dummyDomainRepository() = DomainRepository(
        name = randomString(),
        totalForks = randomInt(),
        totalStars = randomInt(),
        id = randomLong(),
        owner = dummyDomainOwner()
    )

    private fun dummyDomainOwner() = DomainOwner(
        name = randomString(),
        urlPhoto = randomString()
    )

    fun dummyDomainParamsToSearch() = DomainParamsToSearch(
        randomString(),
        randomString(),
        randomString(),
        randomInt()
    )
}