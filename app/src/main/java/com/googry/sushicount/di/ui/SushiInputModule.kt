package com.googry.sushicount.di.ui

import android.app.Application
import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import com.googry.sushicount.di.FragmentScoped
import com.googry.sushicount.ui.sushi.input.SushiInputFragment
import com.googry.sushicount.ui.sushi.input.SushiInputViewModel
import dagger.Module
import dagger.Provides

/**
 * Created by seokjunjeong on 2018. 5. 20..
 */
@Module
class SushiInputModule {

    @FragmentScoped
    @Provides
    fun provideSushiInputViewModel(sushiInputFragment: SushiInputFragment,
                                   application: Application): SushiInputViewModel =
            ViewModelProviders.of(sushiInputFragment, object : ViewModelProvider.Factory {
                @Suppress("UNCHECKED_CAST")
                override fun <T : ViewModel?> create(modelClass: Class<T>): T =
                        SushiInputViewModel(application) as T
            })[SushiInputViewModel::class.java]
}

