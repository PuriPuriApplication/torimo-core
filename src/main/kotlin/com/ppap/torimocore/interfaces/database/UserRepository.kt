package com.ppap.torimocore.interfaces.database

import com.ppap.torimocore.domain.User.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository: JpaRepository<User, Long>
