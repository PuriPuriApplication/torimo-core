package com.ppap.torimocore.presentation.dto

import com.ppap.torimocore.domain.User.User


data class UserDto(
        val id: Long,
        val name: String,
        val externalServiceId: String,
        val externalServiceType: String
) {
    fun convert(): User {
        return User(this.id, this.name, this.externalServiceId, this.externalServiceType, false)
    }
}

fun User.toDto(): UserDto {
    return UserDto(this.id, this.name, this.externalServiceId, this.externalServiceType)
}
