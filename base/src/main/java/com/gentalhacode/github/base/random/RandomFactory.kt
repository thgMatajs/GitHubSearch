package com.gentalhacode.github.base.random

import java.util.*

/**
 * .:.:.:. Created by @thgMatajs on 12/02/20 .:.:.:.
 */
fun randomString() = UUID.randomUUID().toString()
fun randomInt() = Math.random().toInt()
fun randomDouble() = Math.random()
fun randomLong() = Math.random().toLong()
fun randomBoolean() = Math.random().toLong() > 100