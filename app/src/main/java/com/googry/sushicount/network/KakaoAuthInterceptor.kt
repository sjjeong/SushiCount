package com.googry.sushicount.network

import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException

class KakaoAuthInterceptor(private val kakaoRestKey: String) : Interceptor {

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain)
            : Response = with(chain) {
        val newRequest = request().newBuilder().run {
            addHeader("Authorization", "KakaoAK $kakaoRestKey")
            build()
        }
        proceed(newRequest)
    }
}
