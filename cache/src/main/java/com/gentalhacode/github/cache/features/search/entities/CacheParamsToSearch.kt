package com.gentalhacode.github.cache.features.search.entities

import com.gentalhacode.github.model.ParamsToSearch

/**
 * .:.:.:. Created by @thgMatajs on 19/02/20 .:.:.:.
 */
data class CacheParamsToSearch(
    override val language: String,
    override val sort: String,
    override val order: String,
    override var page: Int
) : ParamsToSearch