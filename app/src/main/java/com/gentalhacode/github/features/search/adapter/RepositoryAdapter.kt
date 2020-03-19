package com.gentalhacode.github.features.search.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.api.load
import coil.request.CachePolicy
import coil.size.Precision
import com.gentalhacode.github.R
import com.gentalhacode.github.features.search.model.toView
import com.gentalhacode.github.model.Repository

/**
 * .:.:.:. Created by @thgMatajs on 17/02/20 .:.:.:.
 */
class RepositoryAdapter : PagedListAdapter<Repository, RepositoryViewHolder>(
    RepositoryDiffUtil()
) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepositoryViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.repository_item, parent, false)
        return RepositoryViewHolder(view)
    }

    override fun onBindViewHolder(holder: RepositoryViewHolder, position: Int) = holder.bindView(getItem(position))
}