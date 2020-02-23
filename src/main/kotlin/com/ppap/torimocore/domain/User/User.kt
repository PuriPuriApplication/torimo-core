package com.ppap.torimocore.domain.User

import java.io.Serializable
import javax.persistence.*

typealias UserId = Int
typealias ServiceId = String
/**
 * ユーザー
 */
@Entity
@Table(name = "users")
data class User(

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        val id: UserId,

        @Column(name = "name", nullable = false)
        val name: String,

        @Column(name = "external_service_id", nullable = false)
        val externalServiceId: ServiceId,

        @Column(name = "external_service_type", nullable = false)
        val externalServiceType: String,

        @Column(name = "is_deleted", nullable = false)
        val isDeleted: Boolean

): Serializable
