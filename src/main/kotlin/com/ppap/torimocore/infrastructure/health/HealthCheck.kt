package com.ppap.torimocore.infrastructure.health

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("health")
class HealthCheck {

    @GetMapping
    fun simpleHealthCheck(): Map<String, Any> {
        return mapOf("statusCode" to 200, "message" to "OK")
    }

}