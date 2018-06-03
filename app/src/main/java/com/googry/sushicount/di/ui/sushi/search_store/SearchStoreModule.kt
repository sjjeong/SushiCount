package com.googry.sushicount.di.ui.sushi.search_store

import android.app.Application
import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import com.googry.sushicount.data.source.SearchStoreDataSource
import com.googry.sushicount.di.FragmentScoped
import com.googry.sushicount.ui.sushi.search_store.SearchStoreFragment
import com.googry.sushicount.ui.sushi.search_store.SearchStoreViewModel
import dagger.Module
import dagger.Provides

/**
 * Created by seokjunjeong on 2018. 6. 1..
 */
@Module
class SearchStoreModule {

    @FragmentScoped
    @Provides
    fun provideSearchStoreViewModel(searchStoreFragment: SearchStoreFragment,
                                    application: Application,
                                    searchStoreDataSource: SearchStoreDataSource): SearchStoreViewModel =
            ViewModelProviders.of(searchStoreFragment, object : ViewModelProvider.Factory {
                @Suppress("UNCHECKED_CAST")
                override fun <T : ViewModel?> create(modelClass: Class<T>): T =
                        SearchStoreViewModel(application, searchStoreDataSource) as T
            })[SearchStoreViewModel::class.java]
}