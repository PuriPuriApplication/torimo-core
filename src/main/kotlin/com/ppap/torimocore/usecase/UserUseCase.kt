package com.ppap.torimocore.usecase

import com.ppap.torimocore.domain.User.User
import com.ppap.torimocore.interfaces.database.UserRepository
import com.ppap.torimocore.presentation.dto.UserDto
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

/**
 * ユーザー処理
 */
interface UserUseCase {

    /**
    * ユーザー登録
    */
    fun create(user: User): Unit
}

@Service
class UserUseCaseImpl(private val repository: UserRepository): UserUseCase {

    @Transactional
    override fun create(user: User): Unit {
        repository.save(user);
    }
}