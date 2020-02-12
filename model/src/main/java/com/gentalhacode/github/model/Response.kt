package com.gentalhacode.github.model

/**
 * .:.:.:. Created by @thgMatajs on 11/02/20 .:.:.:.
 */
interface Response {
    val totalRepositories: Int
    val repositories: List<Repository>
}