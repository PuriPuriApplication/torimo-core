package com.ppap.torimocore.presentation.dto

import com.ppap.torimocore.domain.Category.Category

data class CategoryDto(
        val id: Long,
        val name: String
) {
    companion object {
        fun convert(category: Category): CategoryDto {
            return CategoryDto(category.id, category.name)
        }
    }
}
