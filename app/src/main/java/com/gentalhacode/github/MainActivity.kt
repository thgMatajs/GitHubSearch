package com.gentalhacode.github

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.gentalhacode.github.features.search.adapter.RepositoryAdapter
import com.gentalhacode.github.features.search.model.ViewParamsToSearch
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
        searchViewModel.searchRepositoriesBy(
            ViewParamsToSearch(
                language = "language:kotlin"
            )
        )
        observeSearchRepositoriesLiveData()
    }

    private fun observeSearchRepositoriesLiveData() {
        searchViewModel.observeGetRepositoriesLiveData().observe(this, Observer { result ->
            result.handle(
                onLoading = {
                    progressBar.visibility = View.VISIBLE
                },
                onSuccess = { repositories ->
                    adapter.submitList(repositories)
                    progressBar.visibility = View.GONE
                    repositoryRv.visibility = View.VISIBLE
                },
                onError = { error ->
                    Toast.makeText(this, error?.message, Toast.LENGTH_SHORT).show()
                })
        })
    }
}
