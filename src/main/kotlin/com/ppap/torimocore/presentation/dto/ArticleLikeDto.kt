package com.ppap.torimocore.presentation.dto

import com.ppap.torimocore.domain.ArticleLike.ArticleLike
import javax.validation.constraints.NotNull

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
