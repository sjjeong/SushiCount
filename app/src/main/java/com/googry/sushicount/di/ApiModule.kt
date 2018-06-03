package com.googry.sushicount.di

import com.googry.sushicount.network.KakaoRestApi
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.CallAdapter
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton

@Module
class ApiModule {

    @Provides
    @Singleton
    fun provideKakaoRestApi(
            @Named("kakao_authorized") okHttpClient: OkHttpClient,
            callAdapter: CallAdapter.Factory,
            converter: Converter.Factory): KakaoRestApi = Retrofit.Builder()
            .baseUrl("https://dapi.kakao.com/v2/")
            .client(okHttpClient)
            .addCallAdapterFactory(callAdapter)
            .addConverterFactory(converter)
            .build()
            .create(KakaoRestApi::class.java)


    @Provides
    @Singleton
    fun provideCallAdapterFactory(): CallAdapter.Factory = RxJava2CallAdapterFactory.createAsync()

    @Provides
    @Singleton
    fun provideConverterFactory(): Converter.Factory = GsonConverterFactory.create()
}
