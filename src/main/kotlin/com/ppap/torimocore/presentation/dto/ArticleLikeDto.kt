package com.ppap.torimocore.presentation.dto

import com.ppap.torimocore.domain.ArticleLike.ArticleLike

data class ArticleLikeDto(
     val id: Long,
     val articleId: Long,
     val userId: Long
) {
    constructor(entity: ArticleLike) : this(entity.id, entity.articleId, entity.userId)
}

data class ArticleLikeForm(
     val articleId: Long,
     val userId: Long
)

fun convert(form: ArticleLikeForm): ArticleLike {
    return ArticleLike(0, form.articleId, form.userId)
}
