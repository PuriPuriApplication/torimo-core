package com.ppap.torimocore.presentation.dto

import com.ppap.torimocore.domain.Article.Article

data class LikeAndFollowDto(
        val articleLikes: List<ArticleLikeDto>,
        val followUsers: List<FollowUserDto>
)

fun Article.toLikeOrFollowDto(): LikeAndFollowDto {
    val articleLikes: List<ArticleLikeDto> = this.articleLikes.map { it.toDto() }
    val followUsers: List<FollowUserDto> = this.followUsers.map { it.toDto() }
    return LikeAndFollowDto(articleLikes, followUsers)
}
