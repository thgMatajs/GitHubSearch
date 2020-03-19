package com.gentalhacode.github.features.search.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.api.load
import coil.request.CachePolicy
import coil.size.Precision
import com.gentalhacode.github.R
import com.gentalhacode.github.model.Repository

/**
 * .:.:.:. Created by @thgMatajs on 18/03/20 .:.:.:.
 */
class RepositoryViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val itemName: TextView = itemView.findViewById(R.id.repositoryItemName)
    private val itemOwnerName: TextView = itemView.findViewById(R.id.repositoryItemOwner)
    private val itemTotalStars: TextView = itemView.findViewById(R.id.repositoryItemStars)
    private val itemTotalForks: TextView = itemView.findViewById(R.id.repositoryItemForks)
    private val itemIv: ImageView = itemView.findViewById(R.id.repositoryItemIv)

    fun bindView(item: Repository?) {
        item?.apply {
            itemName.text = name
            itemOwnerName.text = owner.name
            itemTotalStars.text = totalStars.toString()
            itemTotalForks.text = totalForks.toString()
            itemIv.load(owner.urlPhoto) {
                crossfade(true)
                size(130, 130)
                precision(Precision.AUTOMATIC)
                diskCachePolicy(CachePolicy.ENABLED)
                memoryCachePolicy(CachePolicy.ENABLED)
            }
        }
    }
}