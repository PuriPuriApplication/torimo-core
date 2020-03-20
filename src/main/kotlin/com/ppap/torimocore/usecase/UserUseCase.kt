package com.ppap.torimocore.usecase

import com.ppap.torimocore.domain.User.User
import com.ppap.torimocore.interfaces.database.UserRepository
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.client.HttpClientErrorException

/**
 * ユーザー処理
 */
interface UserUseCase {

    /**
     * ユーザー登録
     */
    fun create(user: User): User
}

@Service
class UserUseCaseImpl(private val repository: UserRepository) : UserUseCase {

    @Transactional
    override fun create(user: User): User {
        val loadedUser = repository.findByExternalServiceId(user.externalServiceId)
        return loadedUser?.let {
            throw HttpClientErrorException(HttpStatus.BAD_REQUEST)
        } ?: repository.save(user)
    }

}
