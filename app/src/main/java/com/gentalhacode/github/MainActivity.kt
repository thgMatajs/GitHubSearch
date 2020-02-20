package com.gentalhacode.github

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import androidx.lifecycle.Observer
import com.gentalhacode.github.features.search.adapter.RepositoryAdapter
import com.gentalhacode.github.features.search.model.ViewParamsToSearch
import com.gentalhacode.github.features.search.model.toView
import com.gentalhacode.github.presentation.features.search.viewmodel.SearchViewModel
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val searchViewModel: SearchViewModel by viewModel()
    private val adapter: RepositoryAdapter by lazy { RepositoryAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        repositoryRv.adapter = adapter
            searchViewModel.searchRepositoriesBy(ViewParamsToSearch(
                language = "language:kotlin"
            ))
        oberveSearchRepositoriesLiveData()
    }

    private fun oberveSearchRepositoriesLiveData() {
        searchViewModel.observeGetRepositoriesLiveData().observe(this, Observer { result ->
            result.handle(
                onLoading = {
                    println("THG_LOG_LOADING <--")
                    progressBar.visibility = View.VISIBLE
                },
                onSuccess = { repositories ->
                    adapter.submitList(repositories)
                    progressBar.visibility = View.GONE
                    repositoryRv.visibility = View.VISIBLE
                    println("THG_LOG_SUCCESS -->${repositories?.map { it.toView() }}")
                },
                onError = { error ->
                    println("THG_LOG_ERROR -->$error, ${error?.message}")
                })
        })
    }
}
