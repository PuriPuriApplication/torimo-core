package com.ppap.torimocore.domain.User

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "users")
data class User(
        @Id
        @GeneratedValue
        val id: Long
)
