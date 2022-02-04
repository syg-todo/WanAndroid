package com.syg.wanandroid.ui.adapters.binders

import android.graphics.Rect
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSnapHelper
import androidx.recyclerview.widget.RecyclerView
import com.drakeet.multitype.ItemViewBinder
import com.syg.wanandroid.R
import com.syg.wanandroid.ui.adapters.HorizontalOfficialAccountAdapter
import com.syg.wanandroid.ui.adapters.data.OfficialAccount
import com.syg.wanandroid.ui.adapters.data.OfficialAccountList
import com.syg.wanandroid.util.dp2px

/**
 * 水平滑动binder
 * @author shiyonggang
 */
class HorizontalViewBinder :
    ItemViewBinder<OfficialAccountList, HorizontalViewBinder.ViewHolder>() {

    override fun onCreateViewHolder(inflater: LayoutInflater, parent: ViewGroup): ViewHolder {
        return ViewHolder(inflater.inflate(R.layout.item_horizontal_list, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, item: OfficialAccountList) {
        holder.setOfficialAccounts(item.officialAccountList)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val adapter: HorizontalOfficialAccountAdapter = HorizontalOfficialAccountAdapter()
        private val recyclerView: RecyclerView = itemView.findViewById(R.id.official_account_list)

        init {
            val layoutManager = LinearLayoutManager(itemView.context)
            layoutManager.orientation = LinearLayoutManager.HORIZONTAL
            recyclerView.layoutManager = layoutManager
            LinearSnapHelper().attachToRecyclerView(recyclerView)
            recyclerView.adapter = adapter
            recyclerView.addItemDecoration(object : RecyclerView.ItemDecoration() {
                override fun getItemOffsets(
                    outRect: Rect,
                    view: View,
                    parent: RecyclerView,
                    state: RecyclerView.State
                ) {
                    super.getItemOffsets(outRect, view, parent, state)
                    val position = parent.getChildAdapterPosition(view)
                    if (position == 0){
                        outRect.left = dp2px(16f)
                        outRect.right = dp2px(16f)
                    }else{
                        outRect.right = dp2px(16f)
                    }
                }


            })
        }

        fun setOfficialAccounts(oas: List<OfficialAccount>) {
            adapter.setOfficialAccounts(oas)
        }

    }
}