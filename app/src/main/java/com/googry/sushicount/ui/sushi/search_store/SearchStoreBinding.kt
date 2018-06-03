package com.googry.sushicount.ui.sushi.search_store

import android.databinding.BindingAdapter
import android.support.v7.widget.RecyclerView
import com.googry.sushicount.base.BaseRecyclerViewAdapter
import com.googry.sushicount.ext.LogE
import com.googry.sushicount.network.model.KakaoSearchResponse

@BindingAdapter("storeList")
fun replaceStoreList(recyclerView: RecyclerView, storeList: List<KakaoSearchResponse.Document>) {
    LogE("replaceStoreList")
    @Suppress("UNCHECKED_CAST")
    (recyclerView.adapter as? BaseRecyclerViewAdapter<KakaoSearchResponse.Document>)?.run {
        restoreAll(storeList)
        notifyDataSetChanged()
    }
}