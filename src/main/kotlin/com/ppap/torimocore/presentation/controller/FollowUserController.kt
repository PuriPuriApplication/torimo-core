package com.ppap.torimocore.presentation.controller

import com.ppap.torimocore.constants.Response
import com.ppap.torimocore.presentation.dto.FollowUserDto
import com.ppap.torimocore.presentation.dto.FollowUserFormDto
import com.ppap.torimocore.presentation.dto.toDto
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
    fun follow(@RequestBody @Validated form: FollowUserFormDto, bindingResult: BindingResult): Response {
        if (bindingResult.hasErrors()) throw HttpClientErrorException(HttpStatus.BAD_REQUEST, bindingResult.allErrors.toString())
        usecase.follow(form.convert())
        return createResponse(HttpStatus.OK)
    }

    @PostMapping("unfollow")
    fun unfollow(@RequestBody @Validated form: FollowUserFormDto, bindingResult: BindingResult): Response {
        if (bindingResult.hasErrors()) throw HttpClientErrorException(HttpStatus.BAD_REQUEST, bindingResult.allErrors.toString())
        usecase.unfollow(form.convert())
        return createResponse(HttpStatus.OK)
    }

    @GetMapping("/followerCount/{id}")
    fun countFollower(@PathVariable("id") id: Long): Int {
        return usecase.countFollower(id)
    }

    // TODO: パスパラメーターでtoUserもらって、認証情報からfromUserもらって検索？？
    @GetMapping("/isFollow/{toUser}")
    fun showLike(@PathVariable("toUser") toUserId: Long): FollowUserDto? {
        return usecase.showFollow(toUserId)?.let { it.toDto() } ?: throw HttpClientErrorException(HttpStatus.NOT_FOUND)
    }
}
