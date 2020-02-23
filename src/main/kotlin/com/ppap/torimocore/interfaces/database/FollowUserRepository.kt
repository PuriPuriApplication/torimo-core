package com.ppap.torimocore.interfaces.database

import com.ppap.torimocore.domain.FollowUser.FollowUser
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface FollowUserRepository : JpaRepository<FollowUser, Long> {

    fun findByFromUserAndToUser(fromUser: Long, toUser: Long): FollowUser?

}