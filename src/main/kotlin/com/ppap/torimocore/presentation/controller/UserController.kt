package com.ppap.torimocore.presentation.controller

import com.ppap.torimocore.presentation.dto.ArticleLikeFormDto
import com.ppap.torimocore.presentation.dto.UserDto
import com.ppap.torimocore.usecase.ArticleLikeUseCase
import com.ppap.torimocore.usecase.UserUseCase
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
@RequestMapping("/user")
class UserController(private val useCase: UserUseCase): ControllerBase() {

    @PostMapping("create")
    fun create(@RequestBody form: UserDto): Map<String, String?> {
        useCase.create(UserDto.convert(form))
        return createResponse(HttpStatus.OK)
    }

}