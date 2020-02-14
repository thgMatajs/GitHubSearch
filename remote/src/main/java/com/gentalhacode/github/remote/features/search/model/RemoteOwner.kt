package com.gentalhacode.github.remote.features.search.model

import com.gentalhacode.github.model.Owner
import com.google.gson.annotations.SerializedName

/**
 * .:.:.:. Created by @thgMatajs on 13/02/20 .:.:.:.
 */
data class RemoteOwner(
    @SerializedName("login")
    override val name: String,
    @SerializedName("avatar_url")
    override val urlPhoto: String
) : Owner