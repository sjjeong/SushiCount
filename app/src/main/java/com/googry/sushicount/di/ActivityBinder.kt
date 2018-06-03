package com.googry.sushicount.di

import com.googry.sushicount.di.ui.main.MainModule
import com.googry.sushicount.ui.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by seokjunjeong on 2018. 4. 24..
 */
@Module
abstract class ActivityBinder {

    @ActivityScoped
    @ContributesAndroidInjector(modules = [MainModule::class])
    abstract fun mainActivity(): MainActivity
}