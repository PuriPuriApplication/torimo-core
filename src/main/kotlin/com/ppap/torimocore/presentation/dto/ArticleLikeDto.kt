package com.ppap.torimocore.presentation.dto

import com.ppap.torimocore.domain.ArticleLike.ArticleLike

data class ArticleLikeFormDto(
     val articleId: Long,
     val userId: Long
) {
    companion object {
        fun convert(form: ArticleLikeFormDto): ArticleLike {
            return ArticleLike(0, form.articleId, form.userId)
        }
    }
}
