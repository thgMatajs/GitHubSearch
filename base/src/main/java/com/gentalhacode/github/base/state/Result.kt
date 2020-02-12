package com.gentalhacode.github.base.state

/**
 * .:.:.:. Created by @thgMatajs on 11/02/20 .:.:.:.
 */
class Result<out T> constructor(
    private val state: ResultState,
    private val data: T? = null,
    private val exception: Throwable? = null
) {
    fun handle(
        onLoading: () -> Unit,
        onSuccess: (T?) -> Unit,
        onError: (Throwable?) -> Unit
    ) {
        when (state) {
            ResultState.LOADING -> onLoading()
            ResultState.SUCCESS -> onSuccess(data)
            ResultState.ERROR -> onError(exception)
        }
    }
}