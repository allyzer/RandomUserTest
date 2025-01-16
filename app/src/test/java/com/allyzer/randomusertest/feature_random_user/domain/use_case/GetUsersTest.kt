package com.allyzer.randomusertest.feature_random_user.domain.use_case

import com.allyzer.randomusertest.common.Resource
import com.allyzer.randomusertest.feature_random_user.data.remote.dto.Coordinates
import com.allyzer.randomusertest.feature_random_user.data.remote.dto.Dob
import com.allyzer.randomusertest.feature_random_user.data.remote.dto.Id
import com.allyzer.randomusertest.feature_random_user.data.remote.dto.Location
import com.allyzer.randomusertest.feature_random_user.data.remote.dto.Login
import com.allyzer.randomusertest.feature_random_user.data.remote.dto.Name
import com.allyzer.randomusertest.feature_random_user.data.remote.dto.Picture
import com.allyzer.randomusertest.feature_random_user.data.remote.dto.Registered
import com.allyzer.randomusertest.feature_random_user.data.remote.dto.Street
import com.allyzer.randomusertest.feature_random_user.data.remote.dto.Timezone
import com.allyzer.randomusertest.feature_random_user.data.remote.dto.UserDto
import com.allyzer.randomusertest.feature_random_user.data.remote.toUser
import com.allyzer.randomusertest.feature_random_user.data.repository.FakeUserRepository
import com.allyzer.randomusertest.feature_random_user.domain.model.User
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.flow.drop
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class GetUsersTest {
    private lateinit var getUsersUseCase: GetUsersUseCase
    private lateinit var fakeRepository: FakeUserRepository
    private lateinit var testUser: User

    @Before
    fun setUp() {
        fakeRepository = FakeUserRepository()
        getUsersUseCase = GetUsersUseCase(fakeRepository)

        val usersToAdd = mutableListOf<UserDto>()
        ('a'..'z').forEachIndexed { index, c ->
            usersToAdd.add(
                UserDto(
                    cell = c.toString(),
                    dob = Dob(
                        date = c.toString(),
                        age = index
                    ),
                    email = c.toString(),
                    gender = c.toString(),
                    id = Id(),
                    location = Location(
                        city = c.toString(),
                        country = c.toString(),
                        postcode = c.toString(),
                        state = c.toString(),
                        street = Street(
                            name = c.toString(),
                            number = index
                        ),
                        coordinates = Coordinates(
                            latitude = c.toString(),
                            longitude = c.toString()
                        ),
                        timezone = Timezone(
                            description = c.toString(),
                            offset = c.toString()
                        )
                    ),
                    login = Login(
                        md5 = c.toString(),
                        password = c.toString(),
                        salt = c.toString(),
                        sha1 = c.toString(),
                        sha256 = c.toString(),
                        username = c.toString(),
                        uuid = c.toString()
                    ),
                    name = Name(
                        first = c.toString(),
                        last = c.toString(),
                        title = c.toString()
                    ),
                    nat = c.toString(),
                    phone = c.toString(),
                    picture = Picture(
                        large = c.toString(),
                        medium = c.toString(),
                        thumbnail = c.toString()
                    ),
                    registered = Registered(
                        age = index,
                        date = c.toString()
                    )
                )
            )
        }


        testUser = usersToAdd[10].toUser()

        runBlocking {
            usersToAdd.forEach { fakeRepository.addUser(it) }
        }
    }

    @Test
    fun `Get user list, contains data`() = runBlocking {
        val users: Resource<List<User>> = getUsersUseCase(1).drop(1).first()

        assertThat(users.data?.size).isGreaterThan(10)
    }

    @Test
    fun `Get user list, contains testUser`() = runBlocking {
        val users: Resource<List<User>> = getUsersUseCase(1).drop(1).first()

        assertThat(users.data).contains(testUser)
    }
}