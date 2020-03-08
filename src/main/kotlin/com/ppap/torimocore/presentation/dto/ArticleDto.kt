package com.ppap.torimocore.presentation.dto

import com.ppap.torimocore.domain.Article.Article
import java.time.LocalDate

data class ArticleDto(
        val id: Long,
        val title: String,
        val body: String,
        val createAt: LocalDate,
        val user: UserDto,
        val shop: ShopDto,
        val categories: List<CategoryDto>,
        val articleLikes: List<ArticleLikeDto>,
        val followUsers: List<FollowUserDto>
)

fun Article.toDto(): ArticleDto {
    val user: UserDto = this.user.toDto()
    val shop: ShopDto = this.shop.toDto()
    val categories: List<CategoryDto> = this.categories.map { it.toDto() }
    val articleLikes: List<ArticleLikeDto> = this.articleLikes.map { it.toDto() }
    val followUsers: List<FollowUserDto> = this.followUsers.map { it.toDto() }
    return ArticleDto(this.id, this.title, this.body, this.createAt, user, shop, categories, articleLikes, followUsers)
}
