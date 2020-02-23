package com.ppap.torimocore.presentation.controller

import com.ppap.torimocore.presentation.dto.ArticleLikeDto
import com.ppap.torimocore.presentation.dto.ArticleLikeForm
import com.ppap.torimocore.presentation.dto.convert
import com.ppap.torimocore.usecase.ArticleLikeUseCase
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
    fun like(@RequestBody form: ArticleLikeForm): ArticleLikeDto {
        return ArticleLikeDto(useCase.like(convert(form)))
    }

    @PostMapping("unlike")
    fun unlike(@RequestBody form: ArticleLikeForm): Boolean {
        return useCase.unlike(convert(form))
    }

}