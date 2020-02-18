package com.gentalhacode.github.presentation.execution

import com.gentalhacode.github.base.rx.PostExecutionThread
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers

/**
 * .:.:.:. Created by @thgMatajs on 17/02/20 .:.:.:.
 */
class UiThread : PostExecutionThread {

    override val scheduler: Scheduler
        get() = AndroidSchedulers.mainThread()
}