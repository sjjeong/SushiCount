package com.googry.sushicount.di

import com.googry.sushicount.di.ui.SushiInputModule
import com.googry.sushicount.ui.sushi_input.SushiInputFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by seokjunjeong on 2018. 5. 20..
 */
@Module
abstract class FragmentBinder {

    @FragmentScoped
    @ContributesAndroidInjector(modules = [SushiInputModule::class])
    abstract fun sushiInputFragment(): SushiInputFragment
}