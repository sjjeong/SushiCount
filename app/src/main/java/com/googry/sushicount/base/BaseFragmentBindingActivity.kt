package com.googry.sushicount.base

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import com.googry.sushicount.R
import com.googry.sushicount.ext.addFragment
import dagger.android.support.DaggerAppCompatActivity

/**
 * Fragment를 보여주기 위한 Activity
 * Dagger를 사용하지 않음
 */
abstract class BaseFragmentBindingActivity : AppCompatActivity() {
    protected lateinit var fragment: Fragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.base_fragment_binding_activity)
        fragment = createFragment().apply {
            addFragment(this)
        }
    }

    abstract fun createFragment(): Fragment
}