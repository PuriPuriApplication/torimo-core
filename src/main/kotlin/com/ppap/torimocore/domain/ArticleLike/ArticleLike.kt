package com.ppap.torimocore.domain.ArticleLike

import java.io.Serializable
import javax.persistence.*

/**
 * 投稿へのいいね
 */
@Entity
@Table(name = "article_likes")
data class ArticleLike(

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        val id: Long,

        @Column(name = "article_id", nullable = false)
        val articleId: Long,

        @Column(name = "user_id", nullable = false)
        val userId: Long

) : Serializable