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
        val isLike: Boolean
)

fun Article.toDto(): ArticleDto {
    val user: UserDto = this.user.toDto()
    val shop: ShopDto = this.shop.toDto()
    val categories: List<CategoryDto> = this.categories.map { it.toDto() }
    val isLike: Boolean = this.articleLikes.isNotEmpty()
    return ArticleDto(this.id, this.title, this.body, this.createAt, user, shop, categories, isLike)
}
