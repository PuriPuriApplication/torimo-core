package com.ppap.torimocore.presentation.controller

import com.ppap.torimocore.presentation.dto.ArticleDto
import com.ppap.torimocore.presentation.dto.LikeAndFollowDto
import com.ppap.torimocore.presentation.dto.toDto
import com.ppap.torimocore.usecase.ArticleUsecase
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.client.HttpClientErrorException

@RestController
@RequestMapping("/articles")
class ArticleController(private val usecase: ArticleUsecase) : ControllerBase() {

    @GetMapping
    fun index(): List<ArticleDto> {
        return usecase.showList().map { it.toDto() }
    }

    @GetMapping("{id}")
    fun show(@PathVariable("id") id: Long): ArticleDto? = usecase.showDetail(id)?.let { it.toDto() }
            ?: throw HttpClientErrorException(HttpStatus.NOT_FOUND)

    @GetMapping("{id}/like-and-follow")
    fun getLikeAndFollow(@PathVariable("id") id: Long): LikeAndFollowDto? = usecase.showLikeAndFollow(id)
            ?: throw HttpClientErrorException(HttpStatus.NOT_FOUND)
}
