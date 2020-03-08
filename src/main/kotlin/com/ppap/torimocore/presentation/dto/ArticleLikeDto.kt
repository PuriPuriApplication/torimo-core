package com.ppap.torimocore.presentation.dto

import com.ppap.torimocore.domain.ArticleLike.ArticleLike
import javax.validation.constraints.NotNull

data class ArticleLikeDto(
        val articleId: Long,
        val userId: Long
)

fun ArticleLike.toDto(): ArticleLikeDto {
    return ArticleLikeDto(this.articleId, this.userId)
}

data class ArticleLikeFormDto(
        @field:NotNull
        val articleId: Long?,
        @field:NotNull
        val userId: Long?
) {
    fun convert(): ArticleLike {
        // バリデーションでnullをチェックするためnullableにしているため仕方なく強制アンラップをしています
        return ArticleLike(0, this.articleId!!, this.userId!!)
    }
}
