package com.darklabs.basecompose.di.module

import com.darklabs.basecompose.util.CoroutineDispatcherProvider
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    @Singleton
    internal fun provideSchedulers(): CoroutineDispatcherProvider {
        return object : CoroutineDispatcherProvider {
            override fun io(): CoroutineDispatcher = Dispatchers.IO
            override fun main(): CoroutineDispatcher = Dispatchers.Main
        }
    }
}