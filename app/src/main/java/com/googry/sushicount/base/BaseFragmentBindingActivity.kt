package com.googry.sushicount.base

import android.os.Bundle
import android.support.v4.app.Fragment
import com.googry.mogakko.ext.addFragment
import com.googry.sushicount.R
import dagger.android.support.DaggerAppCompatActivity

abstract class BaseFragmentBindingActivity : DaggerAppCompatActivity() {
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