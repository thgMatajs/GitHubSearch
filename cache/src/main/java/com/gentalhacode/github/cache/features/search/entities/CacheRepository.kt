package com.gentalhacode.github.cache.features.search.entities

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.gentalhacode.github.model.Repository

/**
 * .:.:.:. Created by @thgMatajs on 19/02/20 .:.:.:.
 */

@Entity(tableName = "repositories")
class CacheRepository(
    @PrimaryKey
    override val id: Long,
    override val name: String,
    override val totalStars: Int,
    override val totalForks: Int,
    @Embedded(prefix = "owner_")
    override val owner: CacheOwner
) : Repository

fun Repository.toChache() = CacheRepository(
    id = this.id,
    name = this.name,
    totalForks = this.totalStars,
    totalStars = this.totalStars,
    owner = this.owner.toCache()
)