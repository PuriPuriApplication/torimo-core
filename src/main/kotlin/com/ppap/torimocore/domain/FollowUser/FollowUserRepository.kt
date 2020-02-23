package com.ppap.torimocore.domain.FollowUser

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface FollowUserRepository : JpaRepository<FollowUser, Long>