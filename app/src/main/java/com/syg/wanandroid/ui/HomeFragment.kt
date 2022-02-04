package com.syg.wanandroid.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.recyclerview.widget.RecyclerView
import com.drakeet.multitype.MultiTypeAdapter
import com.syg.wanandroid.R
import com.syg.wanandroid.base.BaseFragment
import com.syg.wanandroid.base.HomeViewModel
import com.syg.wanandroid.databinding.FragmentHomeBinding
import com.syg.wanandroid.net.entity.PagesResponse
import com.syg.wanandroid.ui.adapters.binders.ArticleItemViewBinder
import com.syg.wanandroid.ui.adapters.data.Article
import com.syg.wanandroid.util.launchAndCollectIn
import com.syg.wanandroid.util.launchWithLoading


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
        rvHome.adapter = adapter
        adapter.items = items

    }

    private fun initObserver() {
        mViewModel._uiState.launchAndCollectIn(this, Lifecycle.State.STARTED) {
            onSuccess = { result: PagesResponse<List<Article>>? ->

                result?.let { items.addAll(it.datas!!) }
                adapter.notifyDataSetChanged()
            }

            onError  = {
                Log.d(TAG,"error")
            }

            onFailed = {errorCode, errorMsg->
                Log.d(TAG,"fail")

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