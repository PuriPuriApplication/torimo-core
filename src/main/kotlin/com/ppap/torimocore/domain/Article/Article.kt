package com.ppap.torimocore.domain.Article

import com.ppap.torimocore.domain.Shop.Shop
import com.ppap.torimocore.domain.User.User
import javax.persistence.*

@Entity
@Table(name = "articles")
data class Article(
        @Id
        @GeneratedValue
        val id: Long,

        @Column(name = "title", nullable = false)
        val title: String,

        @Column(name = "body")
        val body: String,

        @Column(name = "header_image")
        val headerImage: String,

        @Column(name = "is_deleted", nullable = false)
        val isDeleted: Boolean,

        @ManyToOne
        @JoinColumn(name = "user_id")
        val user: User,

        @ManyToOne
        @JoinColumn(name = "shop_id")
        val shop: Shop
)
