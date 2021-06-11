package com.darklabs.data.di.module

import com.darklabs.data.BuildConfig
import com.darklabs.data.remote.NetworkHelper
import com.darklabs.data.remote.api.JokeApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.ExperimentalSerializationApi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideLoggingInterceptor(): HttpLoggingInterceptor =
        NetworkHelper.createLoggingInterceptor()

    @Provides
    @Singleton
    fun provideHttpClient(loggingInterceptor: HttpLoggingInterceptor): OkHttpClient =
        NetworkHelper.createOkHttpClient(loggingInterceptor)

    @ExperimentalSerializationApi
    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit =
        NetworkHelper.createRetrofitClient(okHttpClient, BuildConfig.BASE_URL)

    @Provides
    @Singleton
    fun provideJokesApiService(retrofit: Retrofit): JokeApiService {
        return retrofit.create(JokeApiService::class.java)
    }
}