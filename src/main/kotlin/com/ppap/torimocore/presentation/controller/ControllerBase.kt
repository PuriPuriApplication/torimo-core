package com.ppap.torimocore.presentation.controller

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.client.HttpClientErrorException
import java.util.*

@CrossOrigin
@RestController
class ControllerBase {

    fun createResponse(status: HttpStatus): Map<String, String?> {
        val map: MutableMap<String, String?> = HashMap()
        map["statusCode"] = status.value().toString()
        map["message"] = status.reasonPhrase
        return map
    }

    @ExceptionHandler(HttpClientErrorException::class)
    fun httpClientError(e: HttpClientErrorException): Map<String, String?> {
        return when (e.statusCode) {
            // 随時必要なStatusを実装してください
            HttpStatus.BAD_REQUEST -> badRequest(e)
            HttpStatus.NOT_FOUND -> notFound(e)
            else -> HashMap() // TODO: 雑だから適切な処理の実装
        }
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    private fun badRequest(e: HttpClientErrorException): Map<String, String?> {
        return createResponse(e)
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    private fun notFound(e: HttpClientErrorException): Map<String, String?> {
        return createResponse(e)
    }

    private fun createResponse(e: HttpClientErrorException): Map<String, String?> {
        val map: MutableMap<String, String?> = HashMap()
        map["statusCode"] = e.statusCode.value().toString()
        map["message"] = e.message
        return map
    }
}
