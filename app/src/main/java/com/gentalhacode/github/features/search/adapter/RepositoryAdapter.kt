package com.gentalhacode.github.features.search.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.api.load
import coil.transform.CircleCropTransformation
import com.gentalhacode.github.R
import com.gentalhacode.github.features.search.model.ViewRepository
import com.gentalhacode.github.model.Repository

/**
 * .:.:.:. Created by @thgMatajs on 17/02/20 .:.:.:.
 */
class RepositoryAdapter : PagedListAdapter<Repository, RepositoryAdapter.ViewHolder>(
    repositoriesDiff
) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.repository_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bindView(getItem(position))

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bindView(item: Repository?) {
            itemView.apply {
                findViewById<TextView>(R.id.repositoryItemName).text = item?.name
                findViewById<TextView>(R.id.repositoryItemOwner).text = item?.owner?.name
                findViewById<TextView>(R.id.repositoryItemStars).text = item?.totalStars.toString()
                findViewById<TextView>(R.id.repositoryItemForks).text = item?.totalForks.toString()
                findViewById<ImageView>(R.id.repositoryItemIv).load(item?.owner?.urlPhoto) {
                    crossfade(true)
                }
            }
        }
    }

    companion object {
        val repositoriesDiff = object : DiffUtil.ItemCallback<Repository>() {
            override fun areItemsTheSame(
                oldItem: Repository,
                newItem: Repository
            ): Boolean {
                return oldItem.id == newItem.id
            }

            @SuppressLint("DiffUtilEquals")
            override fun areContentsTheSame(
                oldItem: Repository,
                newItem: Repository
            ): Boolean {
                return oldItem == newItem
            }
        }
    }
}