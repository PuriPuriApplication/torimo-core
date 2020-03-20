package com.ppap.torimocore.application.filter

import com.ppap.torimocore.usecase.AuthUseCase
import org.springframework.boot.web.servlet.FilterRegistrationBean
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration


@Configuration
class FilterConfig {

    @Bean
    fun authFilter(useCase: AuthUseCase): FilterRegistrationBean<*> {
        // 認証をしたいパスを設定する
        val authUrls = listOf(
                "/test", "/followUser/*"
        )
        val filter = AuthFilter(useCase)
        return FilterRegistrationBean(filter).apply {
            addUrlPatterns(*authUrls.toTypedArray())
            setOrder(Integer.MIN_VALUE)
        }
    }

}
