package com.ppap.torimocore.presentation.dto

import com.ppap.torimocore.domain.User.User

data class UserDto(
        val id: Long,
        val name: String,
        val externalServiceId: String,
        val externalServiceType: String
) {
    companion object {
        fun convert(user: User): UserDto {
            return UserDto(user.id, user.name, user.externalServiceId, user.externalServiceType)

        }
    }
}
