package com.rakesh.omdb.ui.clickable_adapter

interface RecyclerViewClickListener<DataClass> {
    fun onItemClicked(
        data: DataClass?,
        holder: ClickableViewHolder<DataClass>,
        position: Int?
    )
}