package com.syg.wanandroid.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.syg.wanandroid.R
import com.syg.wanandroid.ui.adapters.data.OfficialAccount

class HorizontalOfficialAccountAdapter :
    RecyclerView.Adapter<HorizontalOfficialAccountAdapter.ViewHolder>() {

    private var officialAccountList = emptyList<OfficialAccount>()

    fun setOfficialAccounts(officialAccountList: List<OfficialAccount>) {
        this.officialAccountList = officialAccountList
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var cover: ImageView = itemView.findViewById(R.id.iv_item_oa_icon)
        var popularIndex: TextView = itemView.findViewById(R.id.tv_item_oa_popular_index)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_offical_account, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val officialAccount = officialAccountList[position]
        holder.cover.setImageResource(R.mipmap.avatar)
//        holder.popularIndex.text = officialAccount.popularIndex
    }

    override fun getItemCount(): Int {
        return officialAccountList.size
    }
}