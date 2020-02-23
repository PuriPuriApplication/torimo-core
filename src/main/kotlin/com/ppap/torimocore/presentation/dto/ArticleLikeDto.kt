package com.ppap.torimocore.presentation.dto

import com.ppap.torimocore.domain.ArticleLike.ArticleLike

data class ArticleLikeFormDto(
     val articleId: Long,
     val userId: Long
) {
    fun convert(): ArticleLike {
        return ArticleLike(0, this.articleId, this.userId)
    }
}
