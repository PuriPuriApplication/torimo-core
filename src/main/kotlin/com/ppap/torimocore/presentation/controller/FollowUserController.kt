package com.ppap.torimocore.presentation.controller

import com.ppap.torimocore.presentation.dto.FollowUserFormDto
import com.ppap.torimocore.usecase.FollowUserUseCase
import org.springframework.http.HttpStatus
import org.springframework.validation.BindingResult
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*
import org.springframework.web.client.HttpClientErrorException

/**
 * ユーザーフォローのController
 * FIXME: `/user/{id}/follow`, `/user/{id}/unfollow`にしたいけど一旦こちらで実装
 */
@RestController
@RequestMapping("/followUser")
class FollowUserController(private val usecase: FollowUserUseCase) : ControllerBase() {

    @PostMapping("follow")
    fun follow(@RequestBody @Validated form: FollowUserFormDto, bindingResult: BindingResult): Map<String, String?> {
        if (bindingResult.hasErrors()) throw HttpClientErrorException(HttpStatus.BAD_REQUEST, bindingResult.allErrors.toString())
        usecase.follow(form.convert())
        return createResponse(HttpStatus.OK)
    }

    @PostMapping("unfollow")
    fun unfollow(@RequestBody @Validated form: FollowUserFormDto, bindingResult: BindingResult): Map<String, String?> {
        if (bindingResult.hasErrors()) throw HttpClientErrorException(HttpStatus.BAD_REQUEST, bindingResult.allErrors.toString())
        usecase.unfollow(form.convert())
        return createResponse(HttpStatus.OK)
    }

    @GetMapping("/followerCount/{id}")
    fun countFollower(@PathVariable("id") id: Long): Int {
        return usecase.countFollower(id)
    }
}
