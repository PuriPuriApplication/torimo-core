package com.ppap.torimocore.presentation.controller

import com.ppap.torimocore.presentation.dto.ArticleDto
import com.ppap.torimocore.presentation.dto.toDto
import com.ppap.torimocore.usecase.ArticleUsecase
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/articles")
class ArticleController(private val usecase: ArticleUsecase): ControllerBase() {

    @GetMapping
    fun index(): List<ArticleDto> {
        return usecase.showList().map { it.toDto() }
    }

    @GetMapping("{id}")
    fun show(@PathVariable("id") id: Long): ArticleDto? = usecase.showDetail(id)?.let { it.toDto() }
}
