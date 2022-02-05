package com.syg.wanandroid.ui.adapters

import android.util.ArrayMap
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

    var arrayMap: ArrayMap<Int, Int> = ArrayMap()

    init {
        arrayMap[408] = R.mipmap.icon_oa_hongyang
        arrayMap[409] = R.mipmap.icon_oa_guolin
        arrayMap[410] = R.mipmap.icon_oa_yugangshuo
        arrayMap[411] = R.mipmap.icon_oa_chengxiangmoying
        arrayMap[413] = R.mipmap.icon_oa_android_qunyinzhuan
        arrayMap[414] = R.mipmap.icon_oa_code_xiaosheng
        arrayMap[415] = R.mipmap.icon_oa_googledev
        arrayMap[416] = R.mipmap.icon_oaqizhuoshe
        arrayMap[417] = R.mipmap.icon_oa_meituan
        arrayMap[420] = R.mipmap.icon_oa_gcssloop
        arrayMap[421] = R.mipmap.icon_oa_hulianwangzhencha
        arrayMap[427] = R.mipmap.icon_oa_susion_suixin
        arrayMap[428] = R.mipmap.icon_oa_chengxuyifeiyuan
        arrayMap[434] = R.mipmap.icon_oa_gityuan

    }

    private var officialAccountList = emptyList<OfficialAccount>()

    fun setOfficialAccounts(officialAccountList: List<OfficialAccount>) {
        this.officialAccountList = officialAccountList
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var cover: ImageView = itemView.findViewById(R.id.iv_item_oa_icon)
        var name: TextView = itemView.findViewById(R.id.tv_item_oa_name)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_offical_account, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val officialAccount = officialAccountList[position]
        arrayMap[officialAccount.id]?.let { holder.cover.setImageResource(it) }
        holder.name.text = officialAccount.name
    }

    override fun getItemCount(): Int {
        return officialAccountList.size
    }
}