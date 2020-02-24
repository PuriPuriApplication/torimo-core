package com.ppap.torimocore.presentation.dto

import com.ppap.torimocore.domain.User.User
import com.ppap.torimocore.enum.ExternalServiceTypeEnum


data class UserDto(
        val name: String,
        val externalServiceId: String,
        val externalServiceType: ExternalServiceTypeEnum
) {
    companion object {
        fun convert(form: UserDto): User {
            return User(name = form.name, externalServiceId = form.externalServiceId, externalServiceType =  form.externalServiceType)
        }
    }
}
