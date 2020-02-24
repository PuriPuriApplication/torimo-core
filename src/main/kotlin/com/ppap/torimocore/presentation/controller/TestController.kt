package com.ppap.torimocore.presentation.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController


@RestController
class TestController {

    @GetMapping("/test")
    fun test(): Map<String, String?> {
        return mapOf("test" to "1")
    }

}

