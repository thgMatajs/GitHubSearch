package com.gentalhacode.github.domain.features.search.model

import com.gentalhacode.github.model.ParamsToSearch

/**
 * .:.:.:. Created by @thgMatajs on 18/02/20 .:.:.:.
 */
data class DomainParamsToSearch(
    override val language: String,
    override val sort: String = "stars",
    override val order: String = "desc",
    override var page: Int = 1
) : ParamsToSearch