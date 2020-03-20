package com.ppap.torimocore.presentation.dto

import com.ppap.torimocore.domain.User.User

data class UserFormDto(
        val id: Long,
        val name: String,
        val externalServiceId: String,
        val externalServiceType: String
) {
    fun convert(): User = User(this.id, this.name, this.externalServiceId, this.externalServiceType, false)
}

data class UserDto(
        val id: Long,
        val name: String,
        val externalServiceId: String,
        val externalServiceType: String
)


fun User.toDto(): UserDto {
    return UserDto(this.id, this.name, this.externalServiceId, this.externalServiceType)
}
