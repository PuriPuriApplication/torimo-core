package com.ppap.torimocore.presentation.controller

import com.ppap.torimocore.constants.Response
import com.ppap.torimocore.presentation.dto.ArticleLikeDto
import com.ppap.torimocore.presentation.dto.ArticleLikeFormDto
import com.ppap.torimocore.presentation.dto.UserDto
import com.ppap.torimocore.presentation.dto.toDto
import com.ppap.torimocore.usecase.ArticleLikeUseCase
import org.springframework.http.HttpStatus
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.validation.BindingResult
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*
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

    @GetMapping("/isLike/{articleId}")
    fun showLike(@PathVariable("articleId") articleId: Long, @AuthenticationPrincipal userDto: UserDto): ArticleLikeDto? {
        return useCase.showLike(articleId, userDto.id)?.let { it.toDto() } ?: throw HttpClientErrorException(HttpStatus.NOT_FOUND)
    }

}
