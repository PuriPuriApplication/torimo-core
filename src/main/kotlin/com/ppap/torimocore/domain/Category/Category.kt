package com.ppap.torimocore.domain.Category

import java.io.Serializable
import javax.persistence.*

@Entity
@Table(name = "categories")
data class Category(
        @Id
        @GeneratedValue
        val id: Long,

        @Column(name = "name")
        val name: String
): Serializable
