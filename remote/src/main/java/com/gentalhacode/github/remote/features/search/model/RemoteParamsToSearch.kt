package com.gentalhacode.github.remote.features.search.model

import com.gentalhacode.github.model.ParamsToSearch

/**
 * .:.:.:. Created by @thgMatajs on 18/02/20 .:.:.:.
 */
data class RemoteParamsToSearch(
    override val language: String,
    override val sort: String,
    override val order: String,
    override var page: Int
) : ParamsToSearch

fun ParamsToSearch.toRemote() = RemoteParamsToSearch(
    language = this.language,
    sort = this.sort,
    order = this.order,
    page = this.page
)