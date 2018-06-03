package com.googry.sushicount.ui.sushi.search_store

import android.support.annotation.LayoutRes
import android.view.ViewGroup
import com.googry.sushicount.base.BaseViewHolder
import com.googry.sushicount.databinding.SearchStoreItemBinding
import com.googry.sushicount.network.model.KakaoSearchResponse

class SearchStoreViewHolder(@LayoutRes layoutRes: Int,
                            parent: ViewGroup?):
        BaseViewHolder<KakaoSearchResponse.Document, SearchStoreItemBinding>(
                layoutRes, parent
        ) {

    override fun onViewCreated(item: KakaoSearchResponse.Document?) {
        binding?.document = item
    }
}