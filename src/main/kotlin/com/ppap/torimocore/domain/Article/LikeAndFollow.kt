package com.ppap.torimocore.domain.Article

import com.ppap.torimocore.domain.ArticleLike.ArticleLike
import com.ppap.torimocore.domain.FollowUser.FollowUser
import com.ppap.torimocore.domain.User.User
import java.io.Serializable
import javax.persistence.*

@Entity
@Table(name = "articles")
data class LikeAndFollow(
        @Id
        @GeneratedValue
        val id: Long,

        @ManyToOne
        @JoinColumn(name = "user_id")
        val user: User,

        @OneToMany
        @JoinColumn(name = "article_id", referencedColumnName = "id")
        val articleLikes: List<ArticleLike>,

        @OneToMany
        @JoinColumn(name = "from_user", referencedColumnName = "user_id")
        val followUsers: List<FollowUser>

) : Serializable
