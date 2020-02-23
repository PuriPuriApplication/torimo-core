package com.ppap.torimocore.interfaces.database

import com.ppap.torimocore.domain.Article.Article
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository


@Repository
interface ArticleRepository : JpaRepository<Article, Long> {
}
