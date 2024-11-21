package com.mogun.bblind.data.model

import com.mogun.bblind.data.model.dto.ContentDto
import com.mogun.bblind.domain.model.Content

object ContentMapper {

    fun Content.toRequest() = ContentDto(
        id = id,
        title = title,
        content = content,
        category = category,
        likeCount = likeCount,
        commentCount = commentCount,
        viewCount = viewCount,
    )
}