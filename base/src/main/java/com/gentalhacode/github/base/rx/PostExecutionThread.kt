package com.gentalhacode.github.base.rx

import io.reactivex.Scheduler

/**
 * .:.:.:. Created by @thgMatajs on 11/02/20 .:.:.:.
 */
interface PostExecutionThread {
    val scheduler: Scheduler
}