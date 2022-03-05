package com.syg.wanandroid.ui.adapters

import android.util.Log
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.syg.wanandroid.ui.OfficialAccountArticleListFragment

class OfficialAccountPagerAdapter(activity: FragmentActivity) : FragmentStateAdapter(activity) {

    var chapterId = 0

    fun setId(id: Int) {
        this.chapterId = id
    }

    override fun getItemCount() = 3

    override fun createFragment(position: Int): Fragment {
        Log.d(TAG,"createFragment")
        val fragment = OfficialAccountArticleListFragment(408)
        return fragment
    }

    companion object{
        val TAG = "OfficialAccountPagerAdapter"
    }

}