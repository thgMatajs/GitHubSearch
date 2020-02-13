package com.gentalhacode.github.domain.features.search.model

import com.gentalhacode.github.model.Owner

/**
 * .:.:.:. Created by @thgMatajs on 12/02/20 .:.:.:.
 */
data class DomainOwner(
    override val name: String,
    override val urlPhoto: String) : Owner