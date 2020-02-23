package com.ppap.torimocore.interfaces.database

import com.ppap.torimocore.domain.Shop.Shop
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ShopRepository: JpaRepository<Shop, Long> {
}
