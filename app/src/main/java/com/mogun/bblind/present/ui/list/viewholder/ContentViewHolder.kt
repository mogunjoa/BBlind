package com.mogun.bblind.present.ui.list.viewholder

import androidx.recyclerview.widget.RecyclerView
import com.mogun.bblind.databinding.ItemContentBinding
import com.mogun.bblind.domain.model.Content
import com.mogun.bblind.present.ui.MainActivity.Handler

class ContentViewHolder(
    private val binding: ItemContentBinding,
    private val handler: Handler
): RecyclerView.ViewHolder(binding.root) {

    fun bind(item: Content) {
        binding.item = item
        binding.handler = handler
    }
}