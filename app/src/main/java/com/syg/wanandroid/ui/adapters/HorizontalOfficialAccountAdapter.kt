package com.syg.wanandroid.ui.adapters

import android.util.ArrayMap
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.syg.wanandroid.R
import com.syg.wanandroid.net.WanAndroidRepository
import com.syg.wanandroid.ui.HomeFragmentDirections
import com.syg.wanandroid.ui.adapters.data.OfficialAccount

class HorizontalOfficialAccountAdapter :
    RecyclerView.Adapter<HorizontalOfficialAccountAdapter.ViewHolder>() {

    private val repository by lazy { WanAndroidRepository() }

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
        repository.getImageRes(officialAccount.id)?.let { holder.cover.setImageResource(it) }
        holder.name.text = officialAccount.name
        holder.itemView.setOnClickListener {
            val action = HomeFragmentDirections.actionHomeFragmentToOfficialAccountFragment(
                officialAccount.id,
                officialAccount.name
            )
            it.findNavController()
                .navigate(action)
        }
    }

    override fun getItemCount(): Int {
        return officialAccountList.size
    }
}