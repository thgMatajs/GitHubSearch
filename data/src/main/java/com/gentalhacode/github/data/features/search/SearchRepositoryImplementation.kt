package com.gentalhacode.github.data.features.search

import com.gentalhacode.github.data.features.search.datastore.SearchDataFactory
import com.gentalhacode.github.domain.features.search.repository.SearchRepository
import com.gentalhacode.github.model.Repository
import io.reactivex.Flowable

/**
 * .:.:.:. Created by @thgMatajs on 12/02/20 .:.:.:.
 */
open class SearchRepositoryImplementation(
    private val factory: SearchDataFactory
) : SearchRepository {

    override fun getRepositoriesBy(language: String): Flowable<List<Repository>> {
        return factory.getCache().isCached().flatMapPublisher { isCached ->
            if (isCached) {
                factory.getCache()
                    .getRepositoriesBy(language)
            } else {
                factory.getRemote()
                    .getRepositoriesBy(language)
                    .doOnNext {
                        factory.getCache().save(it)
                            .subscribe(
                                {},
                                { error ->
                                    Flowable.error<Exception>(error)
                                })
                    }
            }
        }.doOnError { error ->
            Flowable.error<Exception>(error)
        }
    }
}