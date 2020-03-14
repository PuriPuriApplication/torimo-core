package com.ppap.torimocore.infrastructure.apiclient

import java.io.Serializable
import java.time.Duration

/**
 * 外部API接続時の設定クラス
 */
class APIConfigure{
    companion object {
        val readTimeout: Duration = Duration.ofSeconds(3)
        val writeTimeout: Duration = Duration.ofSeconds(5)
        val connectTimeout: Duration = Duration.ofSeconds(10)
    }
}
