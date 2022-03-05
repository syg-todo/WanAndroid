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

class HomeViewModel : BaseViewModel() {

    private val repository by lazy { WanAndroidRepository() }

    private val _items = MutableStateFlow<MutableList<Any>>(mutableListOf())
    val items: StateFlow<MutableList<Any>> = _items.asStateFlow()

    private val itemList = arrayListOf<Any>()
    suspend fun requestNet() {
        CoroutineScope(Dispatchers.IO).launch {
            val articleList = async { repository.fetchHomeArticleFromNet() }
            val officialAccountList = async { repository.fetchOfficialAccountFromNet() }
            itemList.addAll(articleList.await().data!!.datas!!)
            itemList.add(1, OfficialAccountList(officialAccountList.await().data!!))
            _items.value= itemList
        }
    }
}