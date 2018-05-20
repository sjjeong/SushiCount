package com.googry.sushicount.ui.timeline

import android.databinding.BindingAdapter
import android.support.v7.widget.RecyclerView
import com.googry.sushicount.base.BaseRecyclerViewAdapter
import com.googry.sushicount.data.model.Timeline

/**
 * Created by seokjunjeong on 2018. 5. 20..
 */
@BindingAdapter("timelines")
fun setTimelines(recyclerView: RecyclerView, timelines: List<Timeline>) {
    @Suppress("UNCHECKED_CAST")
    (recyclerView.adapter as? BaseRecyclerViewAdapter<Timeline>)?.run {
        replaceAll(timelines)
        notifyDataSetChanged()
    }
}