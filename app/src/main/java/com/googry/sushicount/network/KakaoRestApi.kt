package com.googry.sushicount.network

import com.googry.sushicount.network.model.KakaoSearchResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface KakaoRestApi {

    @GET("local/search/keyword.json?category_group_code=FD6")
    fun searchKeyword(
            @Query("query") query: String,
            @Query("x") longitude: String = "",
            @Query("y") latitude: String = "",
            @Query("radius") radius: Int = 500
    ): Single<KakaoSearchResponse>

}