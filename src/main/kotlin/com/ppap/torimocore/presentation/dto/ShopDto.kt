package com.ppap.torimocore.presentation.dto

import com.ppap.torimocore.domain.Shop.Shop

data class ShopDto(
        val id: Long,
        val name: String
) {
    companion object {
        fun convert(shop: Shop): ShopDto {
            return ShopDto(shop.id, shop.name)

        }
    }
}
