package com.ppap.torimocore.interfaces.database

import com.ppap.torimocore.domain.User.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional


@Repository
@Transactional
interface UserRepository: JpaRepository<User, Long> {

    fun findByExternalServiceId(id: String): User?

}
