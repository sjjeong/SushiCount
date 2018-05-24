package com.googry.sushicount.ui.custom

import android.app.Activity
import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import net.daum.mf.map.api.MapView

/**
 * Created by seokjunjeong on 2018. 5. 25..
 */

class NonDragDaumMapView : MapView {
    constructor(activity: Activity) : super(activity)

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)

    constructor(context: Context, attrs: AttributeSet, defStyle: Int) : super(context, attrs, defStyle)

    private var onClickListener: OnClickListener? = null

    init {
        setOnTouchListener { v, event ->
            // 스크롤을 막고 onClick 효과를 만들기
            when (event.action) {
                MotionEvent.ACTION_UP -> onClickListener?.onClick(v)
            }
            true
        }
    }

    override fun setOnClickListener(l: OnClickListener?) {
        onClickListener = l
    }
}
