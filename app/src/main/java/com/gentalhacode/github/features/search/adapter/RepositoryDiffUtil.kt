package com.gentalhacode.github.features.search.adapter

import androidx.recyclerview.widget.DiffUtil
import com.gentalhacode.github.features.search.model.toView
import com.gentalhacode.github.model.Repository

/**
 * .:.:.:. Created by @thgMatajs on 18/03/20 .:.:.:.
 */
class RepositoryDiffUtil : DiffUtil.ItemCallback<Repository>() {
    override fun areItemsTheSame(
        oldItem: Repository,
        newItem: Repository
    ): Boolean {
        return oldItem.toView().id == newItem.toView().id
    }

    override fun areContentsTheSame(
        oldItem: Repository,
        newItem: Repository
    ): Boolean {
        return oldItem.toView() == newItem.toView()
    }
}