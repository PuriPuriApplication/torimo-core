package com.ppap.torimocore.interfaces.apiclient

import com.ppap.torimocore.domain.Article.Article
import retrofit2.Call
import retrofit2.http.POST
import retrofit2.http.PUT

val BASE_URL = "http://torimo.article"

interface ArticleClient {

    @POST("/new")
    fun postArticle(article: Article): Call<ArticleDto>

    @PUT("/update")
    fun updateArticle(article: Article): Call<ArticleDto>

}

data class ArticleDto(
        val id: Long
)

