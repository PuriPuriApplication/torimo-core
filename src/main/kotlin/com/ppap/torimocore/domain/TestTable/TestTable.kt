package com.ppap.torimocore.domain.TestTable

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
data class TestTable(
        @Id
        @GeneratedValue
        val id: Long? = null,
        val name: String? = null
)
