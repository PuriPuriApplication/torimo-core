package com.ppap.torimocore.presentation.controller

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.client.HttpClientErrorException

@CrossOrigin
@RestController
class ControllerBase {

    private val STATUS_CODE = "statusCode"
    private val MESSAGE = "message"

    fun createResponse(status: HttpStatus): Map<String, String?> {
        return mapOf(
                STATUS_CODE  to status.value().toString(),
                MESSAGE  to status.reasonPhrase
        )
    }

    @ExceptionHandler(HttpClientErrorException::class)
    fun httpClientError(e: HttpClientErrorException): Map<String, String?> {
        return when (e.statusCode) {
            // 随時必要なStatusを実装してください
            HttpStatus.BAD_REQUEST -> badRequest(e)
            HttpStatus.NOT_FOUND -> notFound(e)
            else -> emptyMap() // TODO: 雑だから適切な処理の実装
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
        return mapOf(
                STATUS_CODE to e.statusCode.value().toString(),
                MESSAGE to e.message
        )
    }

}
