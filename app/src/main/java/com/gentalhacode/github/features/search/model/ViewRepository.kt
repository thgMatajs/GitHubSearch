package com.gentalhacode.github.features.search.model

import com.gentalhacode.github.model.Repository

/**
 * .:.:.:. Created by @thgMatajs on 17/02/20 .:.:.:.
 */
data class ViewRepository(
    override val id: Long,
    override val name: String,
    override val totalStars: Int,
    override val totalForks: Int,
    override val owner: ViewOwner
) : Repository

fun Repository.toView() = ViewRepository(
    id = this.id,
    name = this.name,
    totalStars = this.totalStars,
    totalForks = this.totalForks,
    owner = this.owner.toView()
)