package com.ppap.torimocore.domain.FollowUser

import java.io.Serializable
import javax.persistence.*


@Entity
@Table(name = "follow_users")
data class FollowUser(

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long,

    @Column(name = "from", nullable = false)
    val from: Long,

    @Column(name = "to", nullable = false)
    val to: Long

): Serializable
