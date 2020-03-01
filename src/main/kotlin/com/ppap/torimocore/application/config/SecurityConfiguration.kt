package com.ppap.torimocore.application.config

import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter

/**
 * Spring SecurityのConfigurationです。
 */
@Configuration
@EnableWebSecurity
class SecurityConfiguration : WebSecurityConfigurerAdapter() {
    @Throws(Exception::class)
    override fun configure(http: HttpSecurity) {
        http.
                // Basic認証の無効化
                authorizeRequests().antMatchers("/").permitAll().and().
                // CSRFトークンの無効化 TODO: 多分いずれちゃんとやらないといけないやーつ
                csrf().disable()
    }
}