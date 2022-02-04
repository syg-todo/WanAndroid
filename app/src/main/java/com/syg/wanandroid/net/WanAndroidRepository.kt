package com.syg.wanandroid.net

import com.syg.wanandroid.base.BaseRepository
import com.syg.wanandroid.net.entity.ApiResponse
import com.syg.wanandroid.net.entity.PagesResponse
import com.syg.wanandroid.ui.adapters.data.Article
import com.syg.wanandroid.ui.adapters.data.OfficialAccount

class WanAndroidRepository : BaseRepository() {

    private val service by lazy {
        RetrofitClient.service
    }

    /**
     * 获取首页文章列表
     */
    suspend fun fetchHomeArticleFromNet(): ApiResponse<PagesResponse<List<Article>>> {
        return executeHttp {
            service.getHomeArticle()
        }
    }

    /**
     * 获取公众号列表
     */
    suspend fun fetchOfficialAccountFromNet(): ApiResponse<List<OfficialAccount>> {
        return executeHttp {
            service.getWxList()
        }
    }
}