package com.ppap.torimocore.interfaces.apiclient

import com.ppap.torimocore.domain.Article.Article
import com.ppap.torimocore.domain.Category.Category
import com.ppap.torimocore.domain.Shop.Shop
import com.ppap.torimocore.domain.User.User
import retrofit2.http.POST
import retrofit2.http.PUT
import java.time.LocalDate

interface ArticleClient {

    /**
     * postするデータはformDtoを作成する
     */
    @POST("/new")
    suspend fun postArticle(article: Article): ArticleDto

    /**
     * putするデータはformDtoを作成する
     */
    @PUT("/update")
    suspend fun updateArticle(article: Article): ArticleDto

}


/**
 * TODO: 以下未完定義
 * PRが肥大化するため次のPRで正確に実装していきます
 */
data class ArticleDto(
        val id: Long,
        val title: String,
        val body: String,
        val createAt: LocalDate,
        val user: UserDto,
        val shop: ShopDto,
        val categories: List<CategoryDto>
) {
    fun convert(): Article {
        val article = Article(this.id, this.title, this.body, this.createAt, this.user.convert(), this.shop.convert())
        article.categories = this.categories.map { it.convert() }
        return article
    }
}

data class UserDto(
        val id: Long,
        val name: String,
        val externalServiceId: String,
        val externalServiceType: String,
        val isDeleted: Boolean
) {
    fun convert(): User {
        return User(this.id, this.name, this.externalServiceId, this.externalServiceType, this.isDeleted)
    }
}

data class CategoryDto(
        val id: Long,
        val name: String
) {
    fun convert(): Category {
        return Category(this.id, this.name)
    }
}

data class ShopDto(
        val id: Long,
        val name: String
) {
    fun convert(): Shop {
        return Shop(this.id, this.name)
    }
}
