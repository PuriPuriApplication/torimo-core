package com.ppap.torimocore.domain.User

import javax.persistence.*

@Entity
@Table(name = "users")
data class User(
        @Id
        @GeneratedValue
        val id: Long,

        @Column(name = "name", nullable = false)
        val name: String,

        @Column(name = "external_service_id", nullable = false)
        val externalServiceId: String,

        @Column(name = "external_service_type", nullable = false)
        val externalServiceType: String
) {}
