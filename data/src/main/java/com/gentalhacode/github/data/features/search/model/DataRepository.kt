package com.gentalhacode.github.data.features.search.model

import com.gentalhacode.github.model.Repository

/**
 * .:.:.:. Created by @thgMatajs on 13/02/20 .:.:.:.
 */
data class DataRepository(
    override val id: Long,
    override val name: String,
    override val totalStars: Int,
    override val totalForks: Int,
    override val owner: DataOwner
) : Repository