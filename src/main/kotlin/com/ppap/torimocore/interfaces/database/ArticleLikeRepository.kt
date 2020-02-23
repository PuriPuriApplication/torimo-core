package com.ppap.torimocore.interfaces.database

import com.ppap.torimocore.domain.ArticleLike.ArticleLike
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional


@Repository
@Transactional
interface ArticleLikeRepository: JpaRepository<ArticleLike, Long> {

    fun findByArticleIdAndUserId(articleId: Long, userId: Long): ArticleLike?

}