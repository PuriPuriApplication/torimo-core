package com.ppap.torimocore.domain.Article

import com.ppap.torimocore.domain.Category.Category
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
        val shop: Shop
) : Serializable {
    @OneToMany
    @JoinTable
    (
            name = "article_categories",
            joinColumns = arrayOf(JoinColumn(name = "article_id")),
            inverseJoinColumns = arrayOf(JoinColumn(name = "category_id")))
    lateinit var categories: List<Category>
}

