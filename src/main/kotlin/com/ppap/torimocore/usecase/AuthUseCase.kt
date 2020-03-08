package com.ppap.torimocore.usecase

import com.ppap.torimocore.domain.User.User
import com.ppap.torimocore.infrastructure.firebase.AuthClient
import com.ppap.torimocore.interfaces.database.UserRepository
import org.springframework.security.authentication.BadCredentialsException
import org.springframework.stereotype.Service

@Service
class AuthUseCase(val userRepository: UserRepository, val authClient: AuthClient) {

    operator fun invoke(noneCheckToken: String?): User {
        try {
            val token = noneCheckToken?: throw BadCredentialsException("トークンがありません")
            val serviceId = authClient.verify(token)?: throw BadCredentialsException("トークンの検証に失敗しました")
            return userRepository.findByExternalServiceId(serviceId) ?: throw BadCredentialsException("ユーザが存在しません")
        } catch (e: Exception) {
            throw BadCredentialsException("トークンが無効です")
        }
    }

}
