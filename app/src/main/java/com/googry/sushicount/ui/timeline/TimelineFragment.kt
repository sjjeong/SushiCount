package com.googry.sushicount.ui.timeline

import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.googry.sushicount.R
import com.googry.sushicount.base.BaseFragment
import com.googry.sushicount.base.BaseRecyclerViewAdapter
import com.googry.sushicount.data.model.Timeline
import com.googry.sushicount.databinding.TimelineFragmentBinding
import com.googry.sushicount.ui.sushi.input.SushiInputActivity
import javax.inject.Inject

/**
 * Created by seokjunjeong on 2018. 5. 20..
 */
class TimelineFragment : BaseFragment<TimelineFragmentBinding>(R.layout.timeline_fragment) {

    @Inject
    lateinit var timelineViewModel: TimelineViewModel

    private val adapter by lazy {
        object : BaseRecyclerViewAdapter<Timeline>() {
            override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
                    TimelineViewHolder(R.layout.timeline_item, parent)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.run {
            vm = timelineViewModel
            v = this@TimelineFragment
            rvContent.adapter = adapter
            rvContent.addOnScrollListener(object : RecyclerView.OnScrollListener() {
                override fun onScrolled(recyclerView: RecyclerView?, dx: Int, dy: Int) {
                    super.onScrolled(recyclerView, dx, dy)
                    if (dy > 0 && fabAddTimeline.visibility == View.VISIBLE) {
                        fabAddTimeline.hide()
                    } else if (dy < 0 && fabAddTimeline.visibility != View.VISIBLE) {
                        fabAddTimeline.show()
                    }
                }
            })
        }
    }

    // DataBinding Function
    fun showAddPopup() {
        startActivity(Intent(context, SushiInputActivity::class.java))
    }
}