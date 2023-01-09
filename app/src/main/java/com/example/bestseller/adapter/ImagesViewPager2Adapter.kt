package com.example.bestseller.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.bestseller.R
import com.example.bestseller.data.model.PagerArticle

class ImagesViewPager2Adapter() : RecyclerView.Adapter<ImagesViewPager2Adapter.ItemViewHolder>() {

    private var dataset = listOf<PagerArticle>()

    class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val itemTitle: TextView = itemView.findViewById(R.id.pager_text)
        val itemDescription: TextView = itemView.findViewById(R.id.pager_description)
        val itemImage: ImageView = itemView.findViewById(R.id.pager_bg_image)

    }

    fun submitList(list: List<PagerArticle>) {
        dataset = list
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val itemLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.fragment_view_pager, parent, false)

        return ItemViewHolder(itemLayout)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val pagerArticle = dataset[position]

        holder.itemTitle.text = pagerArticle.title
        holder.itemDescription.text = pagerArticle.description
        holder.itemImage.setImageResource(pagerArticle.images)

    }

    override fun getItemCount(): Int {
        return dataset.size
    }
}