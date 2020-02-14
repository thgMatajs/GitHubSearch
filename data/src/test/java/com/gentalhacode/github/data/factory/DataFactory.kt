package com.gentalhacode.github.data.factory

import com.gentalhacode.github.base.random.randomInt
import com.gentalhacode.github.base.random.randomLong
import com.gentalhacode.github.base.random.randomString
import com.gentalhacode.github.data.features.search.model.DataOwner
import com.gentalhacode.github.data.features.search.model.DataRepository
import com.gentalhacode.github.model.Repository

/**
 * .:.:.:. Created by @thgMatajs on 13/02/20 .:.:.:.
 */
object DataFactory {

    fun dummyDataRepositories(): List<Repository> = listOf(
        dummyDataRepository(),
        dummyDataRepository(),
        dummyDataRepository(),
        dummyDataRepository(),
        dummyDataRepository(),
        dummyDataRepository()
    )

    private fun dummyDataRepository() = DataRepository(
        name = randomString(),
        totalForks = randomInt(),
        totalStars = randomInt(),
        id = randomLong(),
        owner = dummyDataOwner()
    )

    private fun dummyDataOwner() = DataOwner(
        name = randomString(),
        urlPhoto = randomString()
    )
}