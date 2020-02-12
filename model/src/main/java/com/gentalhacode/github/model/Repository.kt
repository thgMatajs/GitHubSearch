package com.gentalhacode.github.model

/**
 * .:.:.:. Created by @thgMatajs on 11/02/20 .:.:.:.
 */
interface Repository {
    val id: Long
    val name: String
    val totalStars: Int
    val totalForks: Int
    val owner: Owner

}