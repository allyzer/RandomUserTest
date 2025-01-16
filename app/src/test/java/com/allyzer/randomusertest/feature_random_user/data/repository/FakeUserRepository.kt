package com.allyzer.randomusertest.feature_random_user.data.repository

import com.allyzer.randomusertest.common.Resource
import com.allyzer.randomusertest.feature_random_user.data.remote.dto.UserDto
import com.allyzer.randomusertest.feature_random_user.data.remote.toUser
import com.allyzer.randomusertest.feature_random_user.domain.model.User
import com.allyzer.randomusertest.feature_random_user.domain.repository.UserRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import org.json.JSONObject
import retrofit2.HttpException
import java.io.IOException

class FakeUserRepository : UserRepository {
    private val userDtos = mutableListOf<UserDto>()

    override suspend fun getUserList(count: Int): Flow<Resource<List<User>>> {
        return flow {
            try {
                emit(Resource.Loading())
                emit(Resource.Success(userDtos.map { it.toUser() }))
            } catch (e: HttpException) {
                val jsonObj = JSONObject(
                    e.response()?.errorBody()?.string() ?: "An unexpected error has occurred."
                )
                emit(Resource.Error(jsonObj.getString("error")))
            } catch (e: IOException) {
                emit(Resource.Error("Could not connect to the server."))
            }
        }
    }

    fun addUser(userDto: UserDto){
        userDtos.add(userDto)
    }
}