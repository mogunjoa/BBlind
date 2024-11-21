package com.mogun.bblind.di

import com.mogun.bblind.data.repository.ContentRepositoryImpl
import com.mogun.bblind.data.source.local.dao.ContentDao
import com.mogun.bblind.data.source.remote.api.ContentService
import com.mogun.bblind.domain.repository.ContentRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object RepositoryModule {

    @Provides
    @ViewModelScoped
    fun provideContentRepository(
        contentService: ContentService,
        contentDao: ContentDao,
    ): ContentRepository = ContentRepositoryImpl(contentService, contentDao)
}