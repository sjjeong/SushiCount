package com.googry.sushicount.ui.timeline

import android.databinding.ObservableArrayList
import com.googry.sushicount.base.BaseViewModel
import com.googry.sushicount.data.model.Timeline

/**
 * Created by seokjunjeong on 2018. 5. 20..
 */
class TimelineViewModel : BaseViewModel() {

    val timelines = ObservableArrayList<Timeline>()

    init {
        val sample = mutableListOf<Timeline>()
        sample += Timeline("sample1", "으아아아아아")
        sample += Timeline("sample1", "으아아아아아")
        sample += Timeline("sample1", "으아아아아아")
        sample += Timeline("sample1", "으아아아아아")
        sample += Timeline("sample1", "으아아아아아")
        sample += Timeline("sample1", "으아아아아아")
        sample += Timeline("sample1", "으아아아아아")
        sample += Timeline("sample1", "으아아아아아")
        sample += Timeline("sample1", "으아아아아아")
        sample += Timeline("sample1", "으아아아아아")
        sample += Timeline("sample1", "으아아아아아")
        sample += Timeline("sample1", "으아아아아아")
        sample += Timeline("sample1", "으아아아아아")
        sample += Timeline("sample1", "으아아아아아")
        sample += Timeline("sample1", "으아아아아아")
        sample += Timeline("sample1", "으아아아아아")
        sample += Timeline("sample1", "으아아아아아")
        sample += Timeline("sample1", "으아아아아아")
        sample += Timeline("sample1", "으아아아아아")
        sample += Timeline("sample1", "으아아아아아")
        sample += Timeline("sample1", "으아아아아아")
        sample += Timeline("sample1", "으아아아아아")
        sample += Timeline("sample1", "으아아아아아")

        timelines.clear()
        timelines.addAll(sample)
    }
}