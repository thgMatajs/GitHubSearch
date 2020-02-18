package com.gentalhacode.github.presentation.extensions

import androidx.lifecycle.MutableLiveData
import com.gentalhacode.github.base.state.Result
import com.gentalhacode.github.base.state.ResultState

/**
 * .:.:.:. Created by @thgMatajs on 17/02/20 .:.:.:.
 */
fun <T> MutableLiveData<Result<T>>.setLoading() {
    postValue(Result(ResultState.LOADING))
}

fun <T> MutableLiveData<Result<T>>.setSuccess(data: T? = null) {
    postValue(Result(ResultState.SUCCESS, data = data))
}

fun <T> MutableLiveData<Result<T>>.setFailure(error: Throwable) {
    postValue(Result(ResultState.ERROR, exception = error))
}