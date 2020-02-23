package com.ppap.torimocore.presentation.dto

import com.ppap.torimocore.domain.FollowUser.FollowUser
import javax.validation.constraints.NotNull

data class FollowUserFormDto(
        @field:NotNull
        val fromUser: Long?,
        @field:NotNull
        val toUser: Long?
) {
    fun convert(): FollowUser {
        // バリデーションでnullをチェックするためnullableにしているため仕方なく強制アンラップを使用しています
        return FollowUser(0, this.fromUser!!, this.toUser!!)
    }
}