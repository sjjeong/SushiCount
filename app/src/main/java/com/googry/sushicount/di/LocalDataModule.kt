package com.googry.sushicount.di

import com.googry.sushicount.data.source.SearchStoreDataSource
import com.googry.sushicount.data.source.SearchStoreRepository
import com.googry.sushicount.network.KakaoRestApi
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class LocalDataModule {

    @Provides
    @Singleton
    fun provideSearchStoreDataSource(kakaoRestApi: KakaoRestApi): SearchStoreDataSource =
            SearchStoreRepository(kakaoRestApi)
}