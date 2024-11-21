package com.mogun.bblind.domain.usecase

import com.mogun.bblind.domain.model.Content
import com.mogun.bblind.domain.repository.ContentRepository
import javax.inject.Inject

class ContentUseCase @Inject constructor(
    private val contentRepository: ContentRepository,
) {

    fun loadList() = contentRepository.loadList()

    suspend fun save(item: Content) = contentRepository.save(item)
}