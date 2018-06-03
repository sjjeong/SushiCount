package com.googry.sushicount.ui.sushi.search_store

import android.app.Application
import android.databinding.ObservableArrayList
import com.googry.sushicount.base.BaseViewModel
import com.googry.sushicount.data.source.SearchStoreDataSource
import com.googry.sushicount.ext.LogE
import com.googry.sushicount.network.model.KakaoSearchResponse
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.subjects.PublishSubject
import java.util.concurrent.TimeUnit

/**
 * Created by seokjunjeong on 2018. 6. 1..
 */
class SearchStoreViewModel(application: Application,
                           private val searchStoreDataSource: SearchStoreDataSource)
    : BaseViewModel(application, searchStoreDataSource) {

    val storeList = ObservableArrayList<KakaoSearchResponse.Document>()

    val searchEvent = PublishSubject.create<String>()!!

    init {
        compositeDisposable.add(searchEvent.filter { !it.isEmpty() }
                .debounce(300, TimeUnit.MILLISECONDS)
                .subscribe { searchStoreDataSource.searchStore(it) })

        compositeDisposable.add(searchStoreDataSource.getStoreListStream()
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe { LogE("storeList") }
                .subscribe {
                    storeList.clear()
                    storeList.addAll(it)
                })
    }
}