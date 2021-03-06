package com.ppap.torimocore.usecase

import com.ppap.torimocore.domain.Article.Article
import com.ppap.torimocore.interfaces.apiclient.ArticleClient
import com.ppap.torimocore.interfaces.database.ArticleRepository
import kotlinx.coroutines.runBlocking
import org.springframework.stereotype.Service
import retrofit2.Retrofit

interface ArticleUsecase {

    /**
     * 投稿の一覧を参照します
     */
    fun showList(): List<Article>

    /**
     * 投稿の詳細を参照します
     */
    fun showDetail(id: Long): Article?

    /**
     * 記事を投稿します
     */
    fun post(article: Article): Article

    /**
     * 記事を更新します
     */
    fun update(article: Article): Article
}

@Service
class ArticleUsecaseImpl(private val repository: ArticleRepository) : ArticleUsecase {

    val articleClient = Retrofit.Builder().baseUrl("http://torimo.article").build().create(ArticleClient::class.java)

    override fun showList(): List<Article> = repository.findAll()

    override fun showDetail(id: Long): Article? = repository.findById(id).orElse(null)

    override fun post(article: Article): Article = runBlocking {
        articleClient.postArticle(article).convert()
    }

    override fun update(article: Article): Article = runBlocking {
        articleClient.updateArticle(article).convert()
    }
}

