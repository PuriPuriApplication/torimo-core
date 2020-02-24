package com.ppap.torimocore.domain.FollowUser

import java.io.Serializable
import javax.persistence.*


@Entity
@Table(name = "follow_users")
data class FollowUser(

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        val id: Long,

        @Column(name = "from_user", nullable = false)
        val fromUser: Long,

        @Column(name = "to_user", nullable = false)
        val toUser: Long

) : Serializable
