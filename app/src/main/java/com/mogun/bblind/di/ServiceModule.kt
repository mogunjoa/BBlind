package com.mogun.bblind.di

import com.mogun.bblind.data.source.remote.api.ContentService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ServiceModule {

    @Provides
    @Singleton
    fun provideContentService(retrofit: Retrofit): ContentService = retrofit.create(ContentService::class.java)
}