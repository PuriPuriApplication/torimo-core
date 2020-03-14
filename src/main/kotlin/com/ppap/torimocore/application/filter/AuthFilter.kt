package com.ppap.torimocore.application.filter

import com.fasterxml.jackson.databind.ObjectMapper
import com.ppap.torimocore.usecase.AuthUseCase
import org.codehaus.jackson.JsonProcessingException
import org.springframework.http.HttpStatus
import org.springframework.security.authentication.BadCredentialsException
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken
import org.springframework.web.filter.OncePerRequestFilter
import java.io.IOException
import javax.servlet.FilterChain
import javax.servlet.ServletException
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse


class AuthFilter(val useCase: AuthUseCase) : OncePerRequestFilter() {

    @Throws(ServletException::class, IOException::class)
    override fun doFilterInternal(
            request: HttpServletRequest,
            response: HttpServletResponse,
            filterChain: FilterChain
    ) {
        try {
            val token = getToken(request)
            val user = useCase(token)
            SecurityContextHolder.getContext().authentication = PreAuthenticatedAuthenticationToken(user, null)
            filterChain.doFilter(request, response)
        } catch (e: BadCredentialsException) {
            val errorResponse = mapOf(
                    "statusCode" to HttpStatus.UNAUTHORIZED.reasonPhrase,
                    // FIXME '???????' となってしまうので直す
                    "message" to e.localizedMessage
            )
            response.apply {
                status = HttpStatus.INTERNAL_SERVER_ERROR.value()
                writer.write(errorResponse.toJson())
            }
        }
    }

    // リクエストヘッダからトークンを取得します。
    private fun getToken(request: HttpServletRequest): String? {
        val token = request.getHeader("Authorization")
        return if (token == null || !token.startsWith("Bearer ")) {
            null
        } else {
            token.substring("Bearer ".length)
        }
    }

    @Throws(JsonProcessingException::class)
    private fun Map<String, String?>.toJson(): String {
        return ObjectMapper().writeValueAsString(this)
    }

}
