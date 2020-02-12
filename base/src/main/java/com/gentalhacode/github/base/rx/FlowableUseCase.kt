package com.gentalhacode.github.base.rx

import io.reactivex.Flowable
import io.reactivex.Scheduler
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

/**
 * .:.:.:. Created by @thgMatajs on 11/02/20 .:.:.:.
 */
abstract class FlowableUseCase<in Params, T> constructor(
    private val postExecutionThread: PostExecutionThread,
    private val observerSchedulerThread: Scheduler = Schedulers.io()
) {

    private val disposables = CompositeDisposable()

    abstract fun buildUseCaseFlowable(params: Params? = null): Flowable<T>

    open fun execute(
        params: Params?,
        onNext: (T) -> Unit,
        onError: (e: Throwable) -> Unit,
        onCompletable: (() -> Unit)? = null
    ) {
        val flowable = this.buildUseCaseFlowable(params)
            .subscribeOn(observerSchedulerThread)
            .observeOn(postExecutionThread.scheduler)

        addDisposable(flowable
            .subscribe(
                { t: T ->
                    onNext.invoke(t)
                },
                { error ->
                    onError.invoke(error)
                },
                {
                    onCompletable?.invoke()
                }
            ))

    }

    private fun addDisposable(disposable: Disposable) = disposables.add(disposable)

    fun dispose() = disposables.dispose()
}