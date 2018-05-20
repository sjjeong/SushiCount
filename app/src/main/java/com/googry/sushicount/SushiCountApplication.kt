package com.googry.sushicount

import com.googry.sushicount.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication

/**
 * Created by seokjunjeong on 2018. 5. 20..
 */
class SushiCountApplication : DaggerApplication() {
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> =
            DaggerAppComponent.builder().application(this).build()
}