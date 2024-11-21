package com.mogun.bblind.present.ui.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.mogun.bblind.databinding.ItemContentBinding
import com.mogun.bblind.domain.model.Content
import com.mogun.bblind.present.ui.MainActivity.Handler
import com.mogun.bblind.present.ui.list.viewholder.ContentViewHolder

class ListAdpater(
    private val handler: Handler
) : ListAdapter<Content, ContentViewHolder>(diffUtil) {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ContentViewHolder {
        return ContentViewHolder(
            ItemContentBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ),
            handler
        )
    }

    override fun onBindViewHolder(
        holder: ContentViewHolder,
        position: Int
    ) {
        holder.bind(getItem(position))
    }

    companion object {
        val diffUtil = object : DiffUtil.ItemCallback<Content>() {
            override fun areItemsTheSame(
                oldItem: Content,
                newItem: Content
            ): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(
                oldItem: Content,
                newItem: Content
            ): Boolean {
                return oldItem == newItem
            }
        }
    }
}