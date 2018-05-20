package com.googry.sushicount.ui.timeline

import android.support.annotation.LayoutRes
import android.view.ViewGroup
import com.googry.sushicount.base.BaseViewHolder
import com.googry.sushicount.data.model.Timeline
import com.googry.sushicount.databinding.TimelineItemBinding

/**
 * Created by seokjunjeong on 2018. 5. 20..
 */
class TimelineViewHolder(
        @LayoutRes layoutRes: Int,
        parent: ViewGroup?)
    : BaseViewHolder<Timeline, TimelineItemBinding>(layoutRes, parent){

    override fun onViewCreated(item: Timeline?) {
        binding?.run {
            timeline = item
        }
    }
}