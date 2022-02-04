package com.syg.wanandroid.base

import com.syg.wanandroid.net.WanAndroidRepository
import com.syg.wanandroid.net.entity.ApiResponse
import com.syg.wanandroid.net.entity.PagesResponse
import com.syg.wanandroid.ui.adapters.data.Article
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class HomeViewModel :BaseViewModel() {

    private val repository by lazy { WanAndroidRepository() }

     val _uiState = MutableStateFlow<ApiResponse<PagesResponse<List<Article>>>>(ApiResponse())
//    val uiState :StateFlow<ApiResponse<List<Article>>> = _uiState
    suspend fun requestNet(){
        _uiState.value = repository.fetchHomeArticleFromNet()
    }
}