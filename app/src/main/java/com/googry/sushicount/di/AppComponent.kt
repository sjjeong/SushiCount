package com.googry.sushicount.di

import android.app.Application
import com.googry.sushicount.SushiCountApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

/**
 * Created by seokjunjeong on 2018. 4. 24..
 */
@Singleton
@Component(modules = [
    AndroidSupportInjectionModule::class,
    AppModule::class,
    ActivityBinder::class])
interface AppComponent : AndroidInjector<SushiCountApplication> {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(app: Application): Builder

        fun build(): AppComponent
    }
}
