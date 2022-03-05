package com.syg.wanandroid.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView
import com.drakeet.multitype.MultiTypeAdapter
import com.syg.wanandroid.R
import com.syg.wanandroid.base.BaseFragment
import com.syg.wanandroid.databinding.FragmentOfficialAccountArticleListBinding
import com.syg.wanandroid.databinding.FragmentOfficialAccountBinding
import com.syg.wanandroid.ui.adapters.binders.ArticleItemViewBinder
import com.syg.wanandroid.util.launchWithLoading
import com.syg.wanandroid.vm.OfficialAccountArticleListViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class OfficialAccountArticleListFragment(chapterId: Int) : BaseFragment() {


    private val mViewModel by viewModels<OfficialAccountArticleListViewModel>()

    private lateinit var binding: FragmentOfficialAccountArticleListBinding
    private lateinit var rvArticle: RecyclerView
    private lateinit var adapter: MultiTypeAdapter

    private lateinit var items: MutableList<Any>
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d(TAG,"onCreateView")
        binding = FragmentOfficialAccountArticleListBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        initRecyclerView()
        initObserver()
        requestNet()
        return binding.root
    }

    private fun initRecyclerView() {
        items = ArrayList()
        rvArticle = binding.rvOfficialAccountArticleList
        adapter = MultiTypeAdapter()
        adapter.register(ArticleItemViewBinder())
        rvArticle.adapter = adapter
        adapter.items = items
    }

    private fun requestNet() = launchWithLoading { mViewModel.requestNet() }

    private fun initObserver() {
        lifecycleScope.launch {
            mViewModel.items.collect { value ->
                items.addAll(value)
                adapter.notifyDataSetChanged()
            }
        }
    }

    companion object{
        val TAG = "OfficialAccountArticleListFragment"
    }

}