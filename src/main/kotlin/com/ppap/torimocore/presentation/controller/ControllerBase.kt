package com.ppap.torimocore.presentation.controller

import com.ppap.torimocore.constants.*
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.client.HttpClientErrorException
import java.lang.RuntimeException

@CrossOrigin
@RestController
class ControllerBase {

    fun createResponse(status: HttpStatus): Response =
            ResponseEntity(mapOf(STATUS_CODE to status.value(), MESSAGE to status.reasonPhrase), status)

    @ExceptionHandler(HttpClientErrorException::class)
    fun httpClientError(e: HttpClientErrorException): Response = when (e.statusCode) {
        // 随時必要なStatusを実装してください
        HttpStatus.BAD_REQUEST -> badRequest(e)
        HttpStatus.NOT_FOUND -> notFound(e)
        else -> throw RuntimeException("Not implemented handling status code")
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    private fun badRequest(e: HttpClientErrorException): Response = createResponse(e)

    @ResponseStatus(HttpStatus.NOT_FOUND)
    private fun notFound(e: HttpClientErrorException): Response = createResponse(e)

    private fun createResponse(e: HttpClientErrorException): Response =
            ResponseEntity(mapOf(STATUS_CODE to e.statusCode.value(), MESSAGE to e.message), e.statusCode)

}
