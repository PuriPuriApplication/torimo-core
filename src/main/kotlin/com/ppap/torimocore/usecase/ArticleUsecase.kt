package com.ppap.torimocore.usecase

import com.ppap.torimocore.domain.Article.ArticleRepository
import org.springframework.stereotype.Service

@Service
class ArticleUsecase(private val articleRepository: ArticleRepository) {
    fun findAll() = articleRepository.findAll()

    fun findOne(id: Long) = articleRepository.findById(id).orElse(null)
}

