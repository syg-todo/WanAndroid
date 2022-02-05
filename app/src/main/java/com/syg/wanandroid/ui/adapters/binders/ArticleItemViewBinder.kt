package com.syg.wanandroid.ui.adapters.binders

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.drakeet.multitype.ItemViewBinder
import com.syg.wanandroid.R
import com.syg.wanandroid.ui.adapters.data.Article

class ArticleItemViewBinder : ItemViewBinder<Article, ArticleItemViewBinder.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val title: TextView = itemView.findViewById(R.id.tv_item_home_article_title)
        val tag: TextView = itemView.findViewById(R.id.tv_item_home_article_tag1)
        val author: TextView = itemView.findViewById(R.id.tv_item_home_article_author)
        val likes: TextView = itemView.findViewById(R.id.tv_item_home_article_likes)
        val shareDate: TextView = itemView.findViewById(R.id.tv_item_home_article_share_date)
    }

    override fun onBindViewHolder(holder: ViewHolder, item: Article) {
        holder.title.text = item.title
        if (item.tags.isNotEmpty()) {
            item.tags[0].name?.let { holder.tag.text = it }
        }
        if (item.author.isNotEmpty()) {
            holder.author.text = item.author
        } else {
            holder.author.text = item.shareUser
        }
        holder.likes.text = item.zan.toString()
        holder.shareDate.text = item.niceShareDate
    }

    override fun onCreateViewHolder(inflater: LayoutInflater, parent: ViewGroup): ViewHolder {

        return ViewHolder(inflater.inflate(R.layout.item_home_article, parent, false))
    }
}