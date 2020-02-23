package com.ppap.torimocore.presentation.controller

import com.ppap.torimocore.presentation.dto.ArticleLikeFormDto
import com.ppap.torimocore.usecase.ArticleLikeUseCase
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * 投稿いいねのController
 * FIXME: `/article/{id}/like`, `/article/{id}/unlike`にしたいけど一旦こちらで実装
 */
@RestController
@RequestMapping("/article-like")
class ArticleLikeController(private val useCase: ArticleLikeUseCase): ControllerBase() {

    @PostMapping("like")
    fun like(@RequestBody form: ArticleLikeFormDto): Map<String, String?> {
        useCase.like(form.convert())
        return createResponse(HttpStatus.OK)
    }

    @PostMapping("unlike")
    fun unlike(@RequestBody form: ArticleLikeFormDto): Boolean {
        return useCase.unlike(form.convert())
    }

}