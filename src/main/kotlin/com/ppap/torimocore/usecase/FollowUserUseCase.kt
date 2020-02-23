package com.ppap.torimocore.usecase

import com.ppap.torimocore.domain.FollowUser.FollowUser
import com.ppap.torimocore.interfaces.database.FollowUserRepository
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
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
    fun unfollow(followUser: FollowUser)

}

@Service
class FollowUserUseCaseImpl(private val repository: FollowUserRepository) : FollowUserUseCase {

    @Transactional
    override fun follow(followUser: FollowUser): FollowUser {
        if(followUser.fromUser == followUser.toUser) throw HttpClientErrorException(HttpStatus.BAD_REQUEST)
        val followed = repository.findByFromUserAndToUser(followUser.fromUser, followUser.toUser)
        return followed?.let { throw HttpClientErrorException(HttpStatus.BAD_REQUEST) } ?: repository.save(followUser)
    }

    @Transactional
    override fun unfollow(followUser: FollowUser) {
        val followed = repository.findByFromUserAndToUser(followUser.fromUser, followUser.toUser)
        return followed?.let { repository.delete(it) } ?: throw HttpClientErrorException(HttpStatus.BAD_REQUEST)
    }

}