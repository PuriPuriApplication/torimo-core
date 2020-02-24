package com.ppap.torimocore.presentation.dto

import com.ppap.torimocore.domain.Shop.Shop

data class ShopDto(
        val id: Long,
        val name: String
) {
}

fun Shop.toDto(): ShopDto {
    return ShopDto(this.id, this.name)
}
