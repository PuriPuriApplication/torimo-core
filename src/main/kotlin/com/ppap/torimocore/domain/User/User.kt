package com.ppap.torimocore.domain.User

import com.ppap.torimocore.enum.ExternalServiceTypeEnum
import java.io.Serializable
import java.util.*
import javax.persistence.*

/**
 * 投稿へのいいね
 */
@Entity
@Table(name = "users")
data class User(

        @Id
        @Column(name = "id", nullable = true)
        @GeneratedValue(strategy = GenerationType.AUTO)
        val id: Long? = null,

        @Column(name = "name", nullable = false)
        val name: String,

        @Column(name = "external_service_id", nullable = true)
        val externalServiceId: String,

        @Column(name = "external_service_type", nullable = true)
        val externalServiceType: ExternalServiceTypeEnum,

        @Column(name = "create_at", nullable = false)
        val createAt: Date = Date()

): Serializable {


}
