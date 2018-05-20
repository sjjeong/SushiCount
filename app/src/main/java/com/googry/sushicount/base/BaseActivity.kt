package com.googry.sushicount.base

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import dagger.android.support.DaggerAppCompatActivity

/**
 * Created by seokjunjeong on 2018. 5. 20..
 */
abstract class BaseActivity<B : ViewDataBinding>(private val layoutId: Int) : DaggerAppCompatActivity() {
    protected lateinit var binding: B

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, layoutId)
    }
}