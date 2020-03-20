package com.ppap.torimocore.presentation.controller

import com.ppap.torimocore.constants.Response
import com.ppap.torimocore.presentation.dto.UserDto
import com.ppap.torimocore.usecase.UserUseCase
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * ユーザーController
 *
 */
@RestController
@RequestMapping("/user")
class UserController(private val useCase: UserUseCase): ControllerBase() {

    @PostMapping("create")
    fun create(@RequestBody form: UserDto): Response {
        useCase.create(form.convert())
        return createResponse(HttpStatus.OK)
    }

}
