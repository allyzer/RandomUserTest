package com.allyzer.randomusertest.feature_random_user.data.remote

import com.allyzer.randomusertest.feature_random_user.data.remote.dto.Results
import com.allyzer.randomusertest.feature_random_user.data.remote.dto.UserDto
import retrofit2.http.GET
import retrofit2.http.Query

interface RandomUserApi {

    @GET("/api/")
    suspend fun getUserList(@Query("results") userCount: Int): Results
}