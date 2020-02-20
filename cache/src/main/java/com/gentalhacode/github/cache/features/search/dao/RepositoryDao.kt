package com.gentalhacode.github.cache.features.search.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.gentalhacode.github.cache.features.search.entities.CacheRepository
import com.gentalhacode.github.model.Repository
import io.reactivex.Completable
import io.reactivex.Flowable

/**
 * .:.:.:. Created by @thgMatajs on 19/02/20 .:.:.:.
 */
@Dao
interface RepositoryDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(repositories: List<CacheRepository>): Completable


    @Query("SELECT * FROM repositories ORDER BY totalStars DESC")
    fun getRepositoriesBy(): Flowable<List<Repository>>
}