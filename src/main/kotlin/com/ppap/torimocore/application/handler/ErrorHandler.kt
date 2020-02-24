package com.ppap.torimocore.application.handler

import org.springframework.http.HttpStatus
import org.springframework.security.authentication.BadCredentialsException
import java.util.HashMap
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
    fun handleError(): Map<String, Any> {
        val errorMap = HashMap<String, Any>()
        return mapOf(
                "statusCode" to HttpStatus.METHOD_NOT_ALLOWED.value().toString(),
                "message" to "許可されていないメソッドです"
        )
    }

    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(BadCredentialsException::class)
    @ResponseBody
    fun tokenError(e: BadCredentialsException): Map<String, String?> {
        return mapOf(
                "statusCode" to HttpStatus.UNAUTHORIZED.value().toString(),
                "message" to e.message
        )
    }

}
