package com.ppap.torimocore.presentation

import com.ppap.torimocore.domain.Article.Article
import com.ppap.torimocore.usecase.ArticleUsecase
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/articles")
class ArticleController(private val articleUsecase: ArticleUsecase) {

    @GetMapping
    fun index(): List<Article> = articleUsecase.findAll()

    @GetMapping("{id}")
    fun show(@PathVariable("id") id: Long): Article = articleUsecase.findOne(id)
}
