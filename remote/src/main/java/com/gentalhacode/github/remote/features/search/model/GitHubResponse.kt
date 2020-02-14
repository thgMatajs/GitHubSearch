package com.gentalhacode.github.remote.features.search.model

import com.google.gson.annotations.SerializedName

/**
 * .:.:.:. Created by @thgMatajs on 14/02/20 .:.:.:.
 */
data class GitHubResponse(
    @SerializedName("items")
    val repositories: List<RemoteRepository>
)