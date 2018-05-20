package com.googry.mogakko.ext

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentActivity
import com.googry.sushicount.R

/**
 * Created by seokjunjeong on 2018. 5. 7..
 */

internal fun FragmentActivity.addFragment(fragment: Fragment) {
    supportFragmentManager.beginTransaction()
            .add(R.id.content_frame, fragment)
            .commit()
}