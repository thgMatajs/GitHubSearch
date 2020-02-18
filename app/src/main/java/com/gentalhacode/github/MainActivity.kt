package com.gentalhacode.github

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import com.gentalhacode.github.features.search.model.toView
import com.gentalhacode.github.presentation.features.search.viewmodel.SearchViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val searchViewModel: SearchViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        searchViewModel.searchRepositoriesBy("koltin")
        searchViewModel.observeGetRepositoriesLiveData().observe(this, Observer { result ->
            result.handle(
                onLoading = { println("THG_LOG_LOADING --><--") },
                onSuccess = { respositories ->
                    println("THG_LOG_SUCCESS -->${respositories?.map { it.toView() }}")
                },
                onError = { error ->
                    println("THG_LOG_ERROR -->$error, ${error?.message}")
                })
        })
    }
}
