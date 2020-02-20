package com.gentalhacode.github.data.features.search

import com.gentalhacode.github.data.features.search.datastore.SearchDataFactory
import com.gentalhacode.github.domain.features.search.repository.SearchRepository
import com.gentalhacode.github.model.ParamsToSearch
import com.gentalhacode.github.model.Repository
import io.reactivex.Flowable

/**
 * .:.:.:. Created by @thgMatajs on 12/02/20 .:.:.:.
 */
open class SearchRepositoryImplementation(
    private val factory: SearchDataFactory
) : SearchRepository {

    override fun getRepositoriesBy(params: ParamsToSearch): Flowable<List<Repository>> {
//        return factory.getCache().getRepositoriesBy(params).doOnNext {
//            if (it.isEmpty()) {
//                factory.getRemote().getRepositoriesBy(params).subscribe({ remoteRepositories ->
//                    factory.getCache().save(remoteRepositories).subscribe()
//                    Flowable.just(remoteRepositories)
//                }, { error ->
//                    Flowable.error<Throwable>(error)
//                })
//            } else {
//                factory.getCache().getRepositoriesBy(params)
//            }
//        }
        return factory.getCache().isCached().flatMapPublisher { isCached ->
            if (isCached) {
                factory.getCache()
                    .getRepositoriesBy(params)
            } else {
                factory.getRemote()
                    .getRepositoriesBy(params)
                    .doOnNext {
                        factory.getCache().save(it)
                            .subscribe(
                                {  },
                                { error ->
                                    Flowable.error<Exception>(error)
                                })
                    }
            }
        }.doOnError { error ->
            Flowable.error<Throwable>(error)
        }
    }
}