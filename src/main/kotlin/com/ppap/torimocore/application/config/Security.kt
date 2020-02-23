package com.ppap.torimocore.application.config

import com.ppap.torimocore.application.filter.LoginFilter
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.web.csrf.CsrfFilter


@Configuration
@EnableWebSecurity
class Security(val loginFilter: LoginFilter): WebSecurityConfigurerAdapter() {

    override fun configure(http: HttpSecurity) {
        http.addFilterAfter(loginFilter, CsrfFilter::class.java)
    }

}
