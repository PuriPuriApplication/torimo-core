package com.ppap.torimocore.presentation.dto

import com.ppap.torimocore.domain.Article.LikeAndFollow

data class LikeAndFollowDto(
        val articleLikes: List<Long>,
        val followUsers: List<FollowUserDto>
)

fun LikeAndFollow.toLikeOrFollowDto(): LikeAndFollowDto {
    val articleLikes: List<Long> = this.articleLikes.map { it.userId }
    val followUsers: List<FollowUserDto> = this.followUsers.map { it.toDto() }
    return LikeAndFollowDto(articleLikes, followUsers)
}
