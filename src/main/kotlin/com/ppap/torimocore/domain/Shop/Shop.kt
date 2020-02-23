package com.ppap.torimocore.domain.Shop

import java.io.Serializable
import javax.persistence.*

@Entity
@Table(name = "shops")
data class Shop(
        @Id
        @GeneratedValue
        val id: Long,

        @Column(name = "name", nullable = false)
        val name: String
) : Serializable
