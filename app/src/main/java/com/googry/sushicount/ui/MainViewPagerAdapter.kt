package com.googry.sushicount.ui

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import android.util.SparseArray
import com.googry.sushicount.ui.analysis.AnalysisFragment
import com.googry.sushicount.ui.dashboard.DashboardFragment
import com.googry.sushicount.ui.setting.SettingFragment
import com.googry.sushicount.ui.timeline.TimelineFragment

/**
 * Created by seokjunjeong on 2018. 5. 20..
 */

class MainViewPagerAdapter(fm: FragmentManager) : FragmentStatePagerAdapter(fm) {

    private val fragmentPagers = SparseArray<Fragment>()

    init {
        fragmentPagers.append(0, DashboardFragment())
        fragmentPagers.append(1, TimelineFragment())
        fragmentPagers.append(2, AnalysisFragment())
        fragmentPagers.append(3, SettingFragment())
    }

    override fun getCount(): Int = fragmentPagers.size()

    override fun getItem(position: Int): Fragment = fragmentPagers[position]
}