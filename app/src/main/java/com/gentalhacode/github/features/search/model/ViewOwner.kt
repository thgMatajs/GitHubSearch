package com.gentalhacode.github.features.search.model

import com.gentalhacode.github.model.Owner

/**
 * .:.:.:. Created by @thgMatajs on 17/02/20 .:.:.:.
 */
data class ViewOwner(
    override val name: String,
    override val urlPhoto: String
) : Owner

fun Owner.toView() = ViewOwner(
    name = this.name,
    urlPhoto = this.urlPhoto
)