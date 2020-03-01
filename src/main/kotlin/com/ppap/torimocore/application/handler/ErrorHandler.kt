package com.ppap.torimocore.application.handler

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.security.authentication.BadCredentialsException
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.HttpRequestMethodNotSupportedException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus

typealias Body = Map<String, Any?>

@ControllerAdvice
class ExceptionHandler {

    @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
    @ExceptionHandler(HttpRequestMethodNotSupportedException::class)
    @ResponseBody
    fun handleError(): ResponseEntity<Body> = ResponseEntity(mapOf(
            "statusCode" to HttpStatus.METHOD_NOT_ALLOWED.value().toString(),
            "message" to "許可されていないメソッドです"
    ), HttpStatus.METHOD_NOT_ALLOWED)

    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(BadCredentialsException::class)
    @ResponseBody
    fun tokenError(e: BadCredentialsException): ResponseEntity<Body> = ResponseEntity(mapOf(
            "statusCode" to HttpStatus.UNAUTHORIZED.value().toString(),
            "message" to e.message
    ), HttpStatus.UNAUTHORIZED)

}
