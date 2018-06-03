package com.googry.sushicount.data.source

import com.googry.sushicount.network.KakaoRestApi
import com.googry.sushicount.network.model.KakaoSearchResponse
import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.PublishSubject

class SearchStoreRepository(val kakaoRestApi: KakaoRestApi) :
        BaseRepository(), SearchStoreDataSource {

    private val storeStream: PublishSubject<List<KakaoSearchResponse.Document>> = PublishSubject.create()

    override fun getStoreListStream(): PublishSubject<List<KakaoSearchResponse.Document>> = storeStream

    override fun searchStore(keyword: String, longitude: String,
                             latitude: String, radius: Int) {
        compositeDisposable.add(kakaoRestApi
                .searchKeyword(query = keyword,
                        longitude = longitude,
                        latitude = latitude,
                        radius = radius)
                .observeOn(Schedulers.io())
                .map { it.documents }
                .subscribe { it -> storeStream.onNext(it) })
    }
}