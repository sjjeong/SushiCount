package com.googry.sushicount.di

import com.googry.sushicount.di.ui.sushi.input.SushiInputModule
import com.googry.sushicount.di.ui.sushi.search_store.SearchStoreModule
import com.googry.sushicount.ui.sushi.input.SushiInputFragment
import com.googry.sushicount.ui.sushi.search_store.SearchStoreFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by seokjunjeong on 2018. 5. 20..
 */
@Module
abstract class FragmentBinder {

    @FragmentScoped
    @ContributesAndroidInjector(modules = [SushiInputModule::class])
    abstract fun sushiInputFragment(): SushiInputFragment

    @FragmentScoped
    @ContributesAndroidInjector(modules = [SearchStoreModule::class])
    abstract fun searchStoreFragment(): SearchStoreFragment
}