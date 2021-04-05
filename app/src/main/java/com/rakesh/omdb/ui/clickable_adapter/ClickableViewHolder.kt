package com.rakesh.omdb.ui.clickable_adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.rakesh.omdb.utils.setSafeClickListener

open class ClickableViewHolder<Data>(
    v: View,
    adapter: ClickableRecyclerViewAdapter<*, Data>
) : RecyclerView.ViewHolder(v) {

    var position:Int? = 0
    var data: Data? = null

    init {
        v.setSafeClickListener {
            adapter.recyclerViewClickListener?.onItemClicked(
                data,
                this@ClickableViewHolder,
                position
            )
        }
    }
}