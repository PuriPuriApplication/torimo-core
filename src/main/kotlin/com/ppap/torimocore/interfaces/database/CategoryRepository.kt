package com.ppap.torimocore.interfaces.database

import com.ppap.torimocore.domain.Category.Category
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CategoryRepository : JpaRepository<Category, Long>
