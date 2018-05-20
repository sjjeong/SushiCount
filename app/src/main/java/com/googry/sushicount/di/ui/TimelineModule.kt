package com.googry.sushicount.di.ui

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import com.googry.sushicount.di.FragmentScoped
import com.googry.sushicount.ui.timeline.TimelineFragment
import com.googry.sushicount.ui.timeline.TimelineViewModel
import dagger.Module
import dagger.Provides

/**
 * Created by seokjunjeong on 2018. 5. 20..
 */
@Module
class TimelineModule {

    @Provides
    @FragmentScoped
    fun provideTimelineViewModel(timelineFragment: TimelineFragment): TimelineViewModel =
            ViewModelProviders.of(timelineFragment, object : ViewModelProvider.Factory {
                override fun <T : ViewModel?> create(modelClass: Class<T>): T =
                        TimelineViewModel() as T
            })[TimelineViewModel::class.java]
}