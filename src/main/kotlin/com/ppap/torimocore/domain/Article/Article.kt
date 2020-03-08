package com.ppap.torimocore.domain.Article

import com.ppap.torimocore.domain.ArticleLike.ArticleLike
import com.ppap.torimocore.domain.Category.Category
import com.ppap.torimocore.domain.FollowUser.FollowUser
import java.io.Serializable
import com.ppap.torimocore.domain.Shop.Shop
import com.ppap.torimocore.domain.User.User
import java.time.LocalDate
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

        @Column(name = "create_at")
        val createAt: LocalDate,

        @ManyToOne
        @JoinColumn(name = "user_id")
        val user: User,

        @ManyToOne
        @JoinColumn(name = "shop_id")
        val shop: Shop,

        @OneToMany
        @JoinColumn(name = "article_id")
        val articleLikes: List<ArticleLike>,

        @OneToMany
        @JoinColumn(name = "from_user")
        val followUsers: List<FollowUser>

) : Serializable {
    @OneToMany
    @JoinTable
    (
            name = "article_categories",
            joinColumns = [JoinColumn(name = "article_id")],
            inverseJoinColumns = [JoinColumn(name = "category_id")])
    lateinit var categories: List<Category>
}

