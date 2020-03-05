package com.ppap.torimocore.constants

import org.springframework.http.ResponseEntity

val STATUS_CODE = "statusCode"
val MESSAGE = "message"

typealias Body = Map<String, Any?>
typealias Response = ResponseEntity<Body>
