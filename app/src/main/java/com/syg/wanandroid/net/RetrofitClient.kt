package com.syg.wanandroid.net

import com.syg.wanandroid.base.BaseRetrofitClient
import okhttp3.OkHttpClient

object RetrofitClient : BaseRetrofitClient() {
    val service by lazy { getService(WanAndroidService::class.java, WanAndroidService.BASE_URL) }

    override fun handleBuilder(builder: OkHttpClient.Builder) = Unit
}