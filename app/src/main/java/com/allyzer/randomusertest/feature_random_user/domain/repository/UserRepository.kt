package com.allyzer.randomusertest.feature_random_user.domain.repository

import com.allyzer.randomusertest.common.Resource
import com.allyzer.randomusertest.feature_random_user.domain.model.User
import kotlinx.coroutines.flow.Flow

interface UserRepository {

    suspend fun getUserList(count: Int): Flow<Resource<List<User>>>
}