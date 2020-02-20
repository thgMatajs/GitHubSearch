package com.gentalhacode.github.cache.features.search.entities

import com.gentalhacode.github.model.Owner


/**
 * .:.:.:. Created by @thgMatajs on 19/02/20 .:.:.:.
 */
data class CacheOwner(
    override val name: String,
    override val urlPhoto: String
) : Owner

fun Owner.toCache() = CacheOwner(
    name = this.name,
    urlPhoto = this.urlPhoto
)