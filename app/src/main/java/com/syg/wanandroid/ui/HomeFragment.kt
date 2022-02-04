package com.syg.wanandroid.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView
import com.drakeet.multitype.MultiTypeAdapter
import com.syg.wanandroid.base.BaseFragment
import com.syg.wanandroid.base.HomeViewModel
import com.syg.wanandroid.databinding.FragmentHomeBinding
import com.syg.wanandroid.ui.adapters.binders.ArticleItemViewBinder
import com.syg.wanandroid.ui.adapters.binders.HorizontalViewBinder
import com.syg.wanandroid.util.launchWithLoading
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch


class HomeFragment : BaseFragment() {


    private val mViewModel by viewModels<HomeViewModel>()

    private lateinit var binding: FragmentHomeBinding
    private lateinit var rvHome: RecyclerView
    internal lateinit var adapter: MultiTypeAdapter

    internal lateinit var items: MutableList<Any>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        rvHome = binding.rvHome
        initRecyclerView()
        initData()
        initObserver()

        return binding.root
    }

    private fun initRecyclerView() {
        items = ArrayList()
        adapter = MultiTypeAdapter()
        adapter.register(ArticleItemViewBinder())
        adapter.register(HorizontalViewBinder())
        rvHome.adapter = adapter
        adapter.items = items

    }

    private fun initObserver() {
        lifecycleScope.launch {
            mViewModel.items.collect { value ->
                items.addAll(value)
                adapter.notifyDataSetChanged()
            }
        }
    }


    private fun initData() {
        requestNet()
    }

    private fun requestNet() = launchWithLoading { mViewModel.requestNet() }

    companion object {
        private const val TAG = "HomeFragment"
    }
}