package com.syg.wanandroid.net

import com.syg.wanandroid.base.BaseRepository
import com.syg.wanandroid.net.entity.ApiResponse
import com.syg.wanandroid.net.entity.PagesResponse
import com.syg.wanandroid.ui.adapters.data.Article

class WanAndroidRepository : BaseRepository() {

    private val service by lazy {
        RetrofitClient.service
    }

    suspend fun fetchHomeArticleFromNet(): ApiResponse<PagesResponse<List<Article>>> {

        return executeHttp {
            service.getHomeArticle()
        }
    }
}