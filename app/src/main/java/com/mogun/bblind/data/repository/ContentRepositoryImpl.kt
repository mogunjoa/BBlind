package com.mogun.bblind.data.repository

import com.mogun.bblind.data.model.ContentMapper.toContent
import com.mogun.bblind.data.model.ContentMapper.toEntity
import com.mogun.bblind.data.model.ContentMapper.toRequest
import com.mogun.bblind.data.source.local.dao.ContentDao
import com.mogun.bblind.data.source.remote.api.ContentService
import com.mogun.bblind.domain.model.Content
import com.mogun.bblind.domain.repository.ContentRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import okio.IOException
import javax.inject.Inject

class ContentRepositoryImpl @Inject constructor(
    private val contentService: ContentService,
    private val contentDao: ContentDao,
) : ContentRepository {

    override fun loadList(): Flow<List<Content>> {
        return flow {
            try {
                contentService.getList().data.also { list ->
                    contentDao.insertAll(list.map { it.toEntity() })
                }
            } finally {
                contentDao.selectAll().collect { list ->
                    emit(list.map { it.toContent() })
                }
            }
        }
    }

    override suspend fun save(item: Content): Boolean {
        return try {
            contentService.saveItem(item.toRequest()).also {
                if (it.success) {
                    it.data?.let { contentDto ->
                        contentDao.insert(contentDto.toEntity())
                    }
                }
            }

            true
        } catch (e: IOException) {
            false
        }
    }

    override suspend fun update(item: Content): Boolean {
        return try {
            contentService.updateItem(item.toRequest()).also {
                if (it.success) {
                    it.data?.let { contentDto ->
                        contentDao.insert(contentDto.toEntity())
                    }
                }
            }
            true
        } catch (e: IOException) {
            false
        }
    }

    override suspend fun delete(item: Content): Boolean {
        return try {
            item.id?.let {
                contentService.deleteItem(item.id).also {
                    if (it.success) {
                        contentDao.delete(item.toEntity())
                    }
                }
            }
            true
        } catch (e: IOException) {
            false
        }
    }


}