package com.gentalhacode.github.remote.features.search.model

import com.gentalhacode.github.model.Repository
import com.google.gson.annotations.SerializedName

/**
 * .:.:.:. Created by @thgMatajs on 13/02/20 .:.:.:.
 */
data class RemoteRepository(
    @SerializedName("id")
    override val id: Long,
    @SerializedName("name")
    override val name: String,
    @SerializedName("stargazers_count")
    override val totalStars: Int,
    @SerializedName("forks")
    override val totalForks: Int,
    @SerializedName("owner")
    override val owner: RemoteOwner
) : Repository