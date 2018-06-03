package com.googry.sushicount.ui.sushi.search_store

import android.os.Bundle
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.SearchView
import android.view.*
import com.googry.sushicount.R
import com.googry.sushicount.base.BaseFragment
import com.googry.sushicount.base.BaseRecyclerViewAdapter
import com.googry.sushicount.databinding.SearchStoreFragmentBinding
import com.googry.sushicount.ext.LogE
import com.googry.sushicount.network.model.KakaoSearchResponse
import javax.inject.Inject

/**
 * Created by seokjunjeong on 2018. 6. 1..
 */
class SearchStoreFragment
    : BaseFragment<SearchStoreFragmentBinding>(R.layout.search_store_fragment) {

    @Inject
    lateinit var searchStoreViewModel: SearchStoreViewModel

    private lateinit var menuSearch: MenuItem

    private lateinit var searchView: SearchView

    private val searchStoreAdapter by lazy {
        object : BaseRecyclerViewAdapter<KakaoSearchResponse.Document>() {
            override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
                    SearchStoreViewHolder(R.layout.search_store_item, parent)
        }
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.run {
            v = this@SearchStoreFragment
            vm = searchStoreViewModel
            rvContent.adapter = searchStoreAdapter
        }
        setHasOptionsMenu(true)
    }

    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater?.inflate(R.menu.menu_search_store, menu)

        menu?.let {
            menuSearch = it.findItem(R.id.menu_activity_search_query).also {
                searchView = (it.actionView as SearchView).apply {
                    setOnQueryTextListener(object : SearchView.OnQueryTextListener {
                        override fun onQueryTextSubmit(query: String?): Boolean = true

                        override fun onQueryTextChange(newText: String?): Boolean {
                            searchStoreViewModel.searchEvent.onNext(newText ?: "")
                            return true
                        }
                    })
                    setOnSearchClickListener {
                        LogE("searchClick")
                    }

                    setOnQueryTextFocusChangeListener { v, hasFocus ->
                        LogE("hasFocus : $hasFocus")
                    }
                }
            }
        }

    }


}