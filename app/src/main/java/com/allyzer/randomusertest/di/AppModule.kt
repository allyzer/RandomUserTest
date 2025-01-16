package com.allyzer.randomusertest.di

import com.allyzer.randomusertest.common.Constants
import com.allyzer.randomusertest.feature_random_user.data.remote.RandomUserApi
import com.allyzer.randomusertest.feature_random_user.data.repository.UserRepositoryImpl
import com.allyzer.randomusertest.feature_random_user.domain.repository.UserRepository

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun randomUserApi(): RandomUserApi {
        val interceptor = HttpLoggingInterceptor()
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        val client = OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .build()

        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
            .create(RandomUserApi::class.java)
    }

    @Provides
    @Singleton
    fun provideUserRepository(api: RandomUserApi): UserRepository {
        return UserRepositoryImpl(api)
    }
}