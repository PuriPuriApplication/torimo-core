package com.ppap.torimocore.usecase

import com.ppap.torimocore.domain.Article.Article
import com.ppap.torimocore.interfaces.database.ArticleRepository
import com.ppap.torimocore.presentation.dto.LikeAndFollowDto
import com.ppap.torimocore.presentation.dto.toLikeOrFollowDto
import org.springframework.stereotype.Service

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
     * 投稿に対するいいね、フォロー一覧を返します
     */
    fun showLikeAndFollow(id: Long): LikeAndFollowDto?
}

@Service
class ArticleUsecaseImpl(private val repository: ArticleRepository) : ArticleUsecase {
    override fun showList(): List<Article> = repository.findAll()

    override fun showDetail(id: Long): Article? = repository.findById(id).orElse(null)

    override fun showLikeAndFollow(id: Long): LikeAndFollowDto? {
        return repository.findById(id).orElse(null).let { it.toLikeOrFollowDto() }
    }
}

