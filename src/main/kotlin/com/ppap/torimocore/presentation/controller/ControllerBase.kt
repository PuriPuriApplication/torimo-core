package com.ppap.torimocore.presentation.controller

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.client.HttpClientErrorException
import java.lang.RuntimeException

typealias Body = Map<String, Any?>

@CrossOrigin
@RestController
class ControllerBase {

    private val STATUS_CODE = "statusCode"
    private val MESSAGE = "message"

    fun createResponse(status: HttpStatus): ResponseEntity<Body> =
            ResponseEntity(mapOf(STATUS_CODE to status.value(), MESSAGE to status.reasonPhrase), status)

    @ExceptionHandler(HttpClientErrorException::class)
    fun httpClientError(e: HttpClientErrorException): ResponseEntity<Body> = when (e.statusCode) {
        // 随時必要なStatusを実装してください
        HttpStatus.BAD_REQUEST -> badRequest(e)
        HttpStatus.NOT_FOUND -> notFound(e)
        else -> throw RuntimeException("Not implemented handling status code")
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    private fun badRequest(e: HttpClientErrorException): ResponseEntity<Body> = createResponse(e)

    @ResponseStatus(HttpStatus.NOT_FOUND)
    private fun notFound(e: HttpClientErrorException): ResponseEntity<Body> = createResponse(e)

    private fun createResponse(e: HttpClientErrorException): ResponseEntity<Body> =
            ResponseEntity(mapOf(STATUS_CODE to e.statusCode.value(), MESSAGE to e.message), e.statusCode)

}
