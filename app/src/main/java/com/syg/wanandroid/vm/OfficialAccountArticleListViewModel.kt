package com.syg.wanandroid.vm

import com.syg.wanandroid.base.BaseViewModel
import com.syg.wanandroid.net.WanAndroidRepository
import com.syg.wanandroid.ui.adapters.data.OfficialAccountList
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class OfficialAccountArticleListViewModel :BaseViewModel() {
    private val repository by lazy { WanAndroidRepository() }
    private val _items = MutableStateFlow<MutableList<Any>>(mutableListOf())
    val items: StateFlow<MutableList<Any>> = _items.asStateFlow()

    private val itemList = arrayListOf<Any>()

    suspend fun requestNet() {
        CoroutineScope(Dispatchers.IO).launch {
            val articleList = async { repository.fetchOfficialAccountArticleFromNet() }
            itemList.addAll(articleList.await().data!!.datas!!)
            _items.value= itemList
        }
    }
}