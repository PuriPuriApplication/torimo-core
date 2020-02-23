package com.ppap.torimocore.presentation.dto

import com.ppap.torimocore.domain.Category.Category

data class CategoryDto(
        val id: Long,
        val name: String
) {
}

fun Category.toDto(): CategoryDto {
    return CategoryDto(this.id, this.name)
}
