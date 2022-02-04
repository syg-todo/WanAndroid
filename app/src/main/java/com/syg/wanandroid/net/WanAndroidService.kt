package com.syg.wanandroid.net

import com.syg.wanandroid.net.entity.ApiResponse
import com.syg.wanandroid.net.entity.PagesResponse
import com.syg.wanandroid.ui.adapters.data.Article
import retrofit2.http.GET

interface WanAndroidService {
    @GET("article/list/0/json")
    suspend fun getHomeArticle(): ApiResponse<PagesResponse<List<Article>>>

    companion object {
        const val BASE_URL = "https://wanandroid.com/"
    }
}