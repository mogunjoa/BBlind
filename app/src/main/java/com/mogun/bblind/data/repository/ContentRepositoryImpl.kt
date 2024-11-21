package com.mogun.bblind.data.repository

import com.mogun.bblind.data.model.ContentMapper.toEntity
import com.mogun.bblind.data.model.ContentMapper.toRequest
import com.mogun.bblind.data.source.local.dao.ContentDao
import com.mogun.bblind.data.source.remote.api.ContentService
import com.mogun.bblind.domain.model.Content
import com.mogun.bblind.domain.repository.ContentRepository
import okio.IOException
import javax.inject.Inject

class ContentRepositoryImpl @Inject constructor(
    private val contentService: ContentService,
    private val contentDao: ContentDao,
) : ContentRepository {

    override suspend fun save(item: Content): Boolean {
        return try {
            contentService.saveItem(item.toRequest())
            contentDao.insert(item.toEntity())
            true
        } catch (e: IOException) {
            false
        }
    }

    override suspend fun update(item: Content): Boolean {
        return try {
            contentService.updateItem(item.toRequest())
            contentDao.insert(item.toEntity())
            true
        } catch (e: IOException) {
            false
        }
    }


}