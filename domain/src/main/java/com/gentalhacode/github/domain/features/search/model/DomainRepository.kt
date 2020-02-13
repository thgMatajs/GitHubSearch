package com.gentalhacode.github.domain.features.search.model

import com.gentalhacode.github.model.Repository

/**
 * .:.:.:. Created by @thgMatajs on 12/02/20 .:.:.:.
 */
data class DomainRepository(
    override val id: Long,
    override val name: String,
    override val totalStars: Int,
    override val totalForks: Int,
    override val owner: DomainOwner
) : Repository