package com.ppap.torimocore.application.handler

import com.ppap.torimocore.constants.*
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.security.authentication.BadCredentialsException
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.HttpRequestMethodNotSupportedException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus

@ControllerAdvice
class ExceptionHandler {

    @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
    @ExceptionHandler(HttpRequestMethodNotSupportedException::class)
    @ResponseBody
    fun handleError(): Response = ResponseEntity(mapOf(
            STATUS_CODE to HttpStatus.METHOD_NOT_ALLOWED.value().toString(),
            MESSAGE to "許可されていないメソッドです"
    ), HttpStatus.METHOD_NOT_ALLOWED)

    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(BadCredentialsException::class)
    @ResponseBody
    fun tokenError(e: BadCredentialsException): Response = ResponseEntity(mapOf(
            STATUS_CODE to HttpStatus.UNAUTHORIZED.value().toString(),
            MESSAGE to e.message
    ), HttpStatus.UNAUTHORIZED)

}
