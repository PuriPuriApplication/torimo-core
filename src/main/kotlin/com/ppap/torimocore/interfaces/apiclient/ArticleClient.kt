package com.ppap.torimocore.interfaces.apiclient

import retrofit2.Call
import retrofit2.http.POST
import retrofit2.http.PUT

val BASE_URL = "http://torimo.article"

interface ArticleClient {

    @POST("/new")
    fun postArticle(article: Article): Call<ArticleDto>

    @PUT("/update")

}

data class ArticleDto(
        val id: Long
)

