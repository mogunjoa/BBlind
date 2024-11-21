package com.mogun.bblind.domain.repository

import com.mogun.bblind.domain.model.Content

interface ContentRepository {
    suspend fun save(item: Content): Boolean
}