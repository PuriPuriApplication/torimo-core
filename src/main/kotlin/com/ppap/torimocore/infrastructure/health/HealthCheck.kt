package com.ppap.torimocore.infrastructure.health

import com.ppap.torimocore.interfaces.apiclient.ClientCheck
import kotlinx.coroutines.runBlocking
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("health")
class HealthCheck(private val client: ClientCheck) {

    @GetMapping
    fun simpleHealthCheck(): Map<String, Any> {
        return mapOf("statusCode" to 200, "message" to "OK")
    }

    /**
     * 郵便番号から住所を取得する外部APIによるAPIClientの疎通チェックです
     * FYI: https://zipaddress.net/
     */
    @GetMapping("/api")
    fun apiClientCheck(): Map<String, Any> = runBlocking {
        mapOf("statusCode" to 200, "message" to client.test("156-0042"))
    }

}