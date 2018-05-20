package com.googry.sushicount.ui

import android.os.Bundle
import android.support.v4.view.ViewPager
import com.googry.sushicount.R
import com.googry.sushicount.base.BaseActivity
import com.googry.sushicount.databinding.MainActivityBinding

class MainActivity : BaseActivity<MainActivityBinding>(R.layout.main_activity) {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.run {
            vpContent.run {
                adapter = MainViewPagerAdapter(supportFragmentManager)
                offscreenPageLimit = adapter?.count!!
                addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
                    override fun onPageScrollStateChanged(state: Int) {
                    }

                    override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
                    }

                    override fun onPageSelected(position: Int) {
                        bottomNavigationView.selectedItemId = when (position) {
                            0 -> R.id.menu_dashboard
                            1 -> R.id.menu_timeline
                            2 -> R.id.menu_analysis
                            else -> R.id.menu_setting
                        }
                    }

                })
            }
            bottomNavigationView.run {
                setOnNavigationItemSelectedListener {
                    vpContent.currentItem = when (it.itemId) {
                        R.id.menu_dashboard -> 0
                        R.id.menu_timeline -> 1
                        R.id.menu_analysis -> 2
                        else -> 3
                    }
                    true
                }
            }
        }

    }
}
