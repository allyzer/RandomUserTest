package com.allyzer.randomusertest.feature_random_user.domain.use_case

import com.allyzer.randomusertest.common.Resource
import com.allyzer.randomusertest.feature_random_user.domain.model.User
import com.allyzer.randomusertest.feature_random_user.domain.repository.UserRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetUsersUseCase @Inject constructor(
    private val repository: UserRepository,
) {
    suspend operator fun invoke(count: Int): Flow<Resource<List<User>>> {
        return repository.getUserList(count)
    }
}