package com.ppap.torimocore.application.apiclient

import com.ppap.torimocore.infrastructure.apiclient.APIClientFactory
import com.ppap.torimocore.interfaces.apiclient.ArticleClient
import com.ppap.torimocore.interfaces.apiclient.ClientCheck
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class APIClientBean {

    @Value("\${api.client.check}")
    private lateinit var API_CLIENT_CHECK: String

    @Bean
    fun testClient(): ClientCheck {
        return APIClientFactory.create(API_CLIENT_CHECK, ClientCheck::class.java)
    }

    @Value("\${api.article.post}")
    private lateinit var ARTICLE_CLIENT_API: String

    @Bean
    fun articleClient(): ArticleClient {
        return APIClientFactory.create(ARTICLE_CLIENT_API, ArticleClient::class.java)
    }

}