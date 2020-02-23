package com.ppap.torimocore.usecase

import com.ppap.torimocore.domain.FollowUser.FollowUser
import com.ppap.torimocore.interfaces.database.FollowUserRepository
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.client.HttpClientErrorException

/**
 * ユーザーフォローの処理
 */
interface FollowUserUseCase {

    /**
     * フォローします
     */
    fun follow(followUser: FollowUser): FollowUser

    /**
     * フォローを外します
     */
    fun unfollow(followUser: FollowUser): Boolean

}

@Service
class FollowUserUseCaseImpl(private val repository: FollowUserRepository): FollowUserUseCase {

    override fun follow(followUser: FollowUser): FollowUser {
        val followed = repository.findByFromAndTo(followUser.from, followUser.to)
        return followed?.let { throw HttpClientErrorException(HttpStatus.BAD_REQUEST) } ?: repository.save(followUser)
    }

    override fun unfollow(followUser: FollowUser): Boolean {
        val followed = repository.findByFromAndTo(followUser.from, followUser.to)
        return followed?.let {
            repository.delete(followUser)
            true
        } ?: false
    }

}