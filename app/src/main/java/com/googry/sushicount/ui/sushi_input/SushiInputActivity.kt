package com.googry.sushicount.ui.sushi_input

import android.support.v4.app.Fragment
import com.googry.sushicount.base.BaseFragmentBindingActivity

/**
 * Created by seokjunjeong on 2018. 5. 20..
 */
class SushiInputActivity : BaseFragmentBindingActivity() {
    override fun createFragment(): Fragment = SushiInputFragment()
}