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
        val categories: List<CategoryDto>
) {
    companion object {
        fun convert(article: Article): ArticleDto {
            val user: UserDto = UserDto.convert(article.user)
            val shop: ShopDto = ShopDto.convert(article.shop)
            val categories: List<CategoryDto> = article.categories.map {  CategoryDto.convert(it) }
            return ArticleDto(article.id, article.title, article.body, article.createAt, user, shop, categories)
        }
    }
}
