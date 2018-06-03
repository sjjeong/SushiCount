package com.googry.sushicount.data.source

import com.googry.sushicount.network.model.KakaoSearchResponse
import io.reactivex.disposables.Disposable
import io.reactivex.subjects.PublishSubject

interface SearchStoreDataSource: BaseDataSource {

    fun getStoreListStream(): PublishSubject<List<KakaoSearchResponse.Document>>

    fun searchStore(keyword: String,
                    longitude: String = "",
                    latitude: String = "",
                    radius: Int = 500)
}