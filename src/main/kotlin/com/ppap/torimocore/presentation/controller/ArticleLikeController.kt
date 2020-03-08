package com.ppap.torimocore.presentation.controller

import com.ppap.torimocore.constants.Response
import com.ppap.torimocore.presentation.dto.ArticleLikeFormDto
import com.ppap.torimocore.usecase.ArticleLikeUseCase
import org.springframework.http.HttpStatus
import org.springframework.validation.BindingResult
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.client.HttpClientErrorException

/**
 * 投稿いいねのController
 * FIXME: `/article/{id}/like`, `/article/{id}/unlike`にしたいけど一旦こちらで実装
 */
@RestController
@RequestMapping("/article-like")
class ArticleLikeController(private val useCase: ArticleLikeUseCase) : ControllerBase() {

    @PostMapping("like")
    fun like(@RequestBody @Validated form: ArticleLikeFormDto, bindingResult: BindingResult): Response {
        if (bindingResult.hasErrors()) throw HttpClientErrorException(HttpStatus.BAD_REQUEST, bindingResult.allErrors.toString())
        useCase.like(form.convert())
        return createResponse(HttpStatus.OK)
    }

    @PostMapping("unlike")
    fun unlike(@RequestBody form: ArticleLikeFormDto, bindingResult: BindingResult): Response {
        if (bindingResult.hasErrors()) throw HttpClientErrorException(HttpStatus.BAD_REQUEST, bindingResult.allErrors.toString())
        useCase.unlike(form.convert())
        return createResponse(HttpStatus.OK)
    }

}