package com.ppap.torimocore.interfaces.database

import com.ppap.torimocore.domain.Article.LikeAndFollow
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface LikeAndFollowRepository: JpaRepository<LikeAndFollow, Long>
