package com.ppap.torimocore.interfaces.database

import com.ppap.torimocore.domain.User.ServiceId
import com.ppap.torimocore.domain.User.User
import com.ppap.torimocore.domain.User.UserId
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository: JpaRepository<User, UserId> {

    fun findByExternalServiceId(id: ServiceId): User?
}
