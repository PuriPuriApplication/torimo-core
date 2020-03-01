package com.ppap.torimocore.usecase

import com.ppap.torimocore.domain.ArticleLike.ArticleLike
import com.ppap.torimocore.interfaces.database.ArticleLikeRepository
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.client.HttpClientErrorException

/**
 * 投稿のいいね処理
 */
interface ArticleLikeUseCase {

    /**
     * 投稿にいいねをします
     */
    fun like(articleLike: ArticleLike): ArticleLike

    /**
     * 投稿のいいねを外します
     */
    fun unlike(articleLike: ArticleLike)

}

@Service
class ArticleLikeUseCaseImpl(private val repository: ArticleLikeRepository) : ArticleLikeUseCase {

    @Transactional
    override fun like(articleLike: ArticleLike): ArticleLike {
        val liked = repository.findByArticleIdAndUserId(articleLike.articleId, articleLike.userId)
        return liked?.let { throw HttpClientErrorException(HttpStatus.BAD_REQUEST) } ?: repository.save(articleLike)
    }

    @Transactional
    override fun unlike(articleLike: ArticleLike) {
        val liked = repository.findByArticleIdAndUserId(articleLike.articleId, articleLike.userId)
        return liked?.let { repository.delete(it) } ?: throw HttpClientErrorException(HttpStatus.BAD_REQUEST)
    }

}
