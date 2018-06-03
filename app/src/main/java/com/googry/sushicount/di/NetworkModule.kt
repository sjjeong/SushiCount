package com.googry.sushicount.di

import android.content.Context
import com.googry.sushicount.R
import com.googry.sushicount.network.KakaoAuthInterceptor
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import javax.inject.Named
import javax.inject.Singleton

@Module
class NetworkModule {

    @Provides
    @Named("kakao_authorized")
    @Singleton
    fun provideAuthorizedOkHttpClient(
            loggingInterceptor: HttpLoggingInterceptor,
            authInterceptor: KakaoAuthInterceptor): OkHttpClient = OkHttpClient.Builder()
            .addInterceptor(authInterceptor)
            .addInterceptor(loggingInterceptor)
            .build()

    @Provides
    @Singleton
    fun provideLoggingInterceptor(): HttpLoggingInterceptor =
            HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY }

    @Provides
    @Singleton
    fun provideAuthInterceptor(@Named("appContext") context: Context): KakaoAuthInterceptor =
            KakaoAuthInterceptor(context.getString(R.string.kakao_rest_key))
}
