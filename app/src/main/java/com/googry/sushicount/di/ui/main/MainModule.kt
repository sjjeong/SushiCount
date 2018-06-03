package com.googry.sushicount.di.ui.main

import com.googry.sushicount.di.FragmentScoped
import com.googry.sushicount.ui.analysis.AnalysisFragment
import com.googry.sushicount.ui.dashboard.DashboardFragment
import com.googry.sushicount.ui.setting.SettingFragment
import com.googry.sushicount.ui.timeline.TimelineFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by seokjunjeong on 2018. 5. 20..
 */

@Module
abstract class MainModule {

    @ContributesAndroidInjector(modules = [DashboardModule::class])
    @FragmentScoped
    abstract fun dashboardFragment(): DashboardFragment

    @ContributesAndroidInjector(modules = [TimelineModule::class])
    @FragmentScoped
    abstract fun timelineFragment(): TimelineFragment

    @ContributesAndroidInjector(modules = [AnalysisModule::class])
    @FragmentScoped
    abstract fun analysisFragment(): AnalysisFragment

    @ContributesAndroidInjector(modules = [SettingModule::class])
    @FragmentScoped
    abstract fun settingFragment(): SettingFragment
}