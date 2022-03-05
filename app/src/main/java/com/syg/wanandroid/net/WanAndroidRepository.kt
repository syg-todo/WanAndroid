package com.syg.wanandroid.net

import android.util.ArrayMap
import com.syg.wanandroid.R
import com.syg.wanandroid.base.BaseRepository
import com.syg.wanandroid.net.entity.ApiResponse
import com.syg.wanandroid.net.entity.PagesResponse
import com.syg.wanandroid.ui.adapters.data.Article
import com.syg.wanandroid.ui.adapters.data.OfficialAccount

class WanAndroidRepository : BaseRepository() {

    private val service by lazy {
        RetrofitClient.service
    }
    private var arrayMap: ArrayMap<Int, Int> = ArrayMap()

    init {
        arrayMap[408] = R.mipmap.icon_oa_hongyang
        arrayMap[409] = R.mipmap.icon_oa_guolin
        arrayMap[410] = R.mipmap.icon_oa_yugangshuo
        arrayMap[411] = R.mipmap.icon_oa_chengxiangmoying
        arrayMap[413] = R.mipmap.icon_oa_android_qunyinzhuan
        arrayMap[414] = R.mipmap.icon_oa_code_xiaosheng
        arrayMap[415] = R.mipmap.icon_oa_googledev
        arrayMap[416] = R.mipmap.icon_oaqizhuoshe
        arrayMap[417] = R.mipmap.icon_oa_meituan
        arrayMap[420] = R.mipmap.icon_oa_gcssloop
        arrayMap[421] = R.mipmap.icon_oa_hulianwangzhencha
        arrayMap[427] = R.mipmap.icon_oa_susion_suixin
        arrayMap[428] = R.mipmap.icon_oa_chengxuyifeiyuan
        arrayMap[434] = R.mipmap.icon_oa_gityuan
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

    suspend fun fetchOfficialAccountArticleFromNet(): ApiResponse<PagesResponse<List<Article>>> {
        return executeHttp {
            service.getOfficialAccountArticle(408, 1)
        }
    }

    fun getImageRes(id: Int) = arrayMap[id]


}