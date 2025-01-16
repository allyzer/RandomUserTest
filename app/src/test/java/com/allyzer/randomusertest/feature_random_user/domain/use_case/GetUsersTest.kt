package com.allyzer.randomusertest.feature_random_user.domain.use_case

import com.allyzer.randomusertest.common.Resource
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

        val usersToAdd = mutableListOf<User>()
        ('a'..'z').forEachIndexed { index, c ->
            usersToAdd.add(
                User(
                    cell = c.toString(),
                    gender = c.toString(),
                    nat = c.toString(),
                    phone = c.toString(),
                    title = c.toString(),
                    first = c.toString(),
                    last = c.toString(),
                    streetNumber = index,
                    streetName = c.toString(),
                    city = c.toString(),
                    state = c.toString(),
                    country = c.toString(),
                    postcode = c.toString(),
                    pictureLarge = "https://randomuser.me/api/portraits/men/0.jpg",
                    pictureMedium = "https://randomuser.me/api/portraits/med/men/0.jpg",
                    pictureThumbnail = "https://randomuser.me/api/portraits/thumb/men/0.jpg",
                    latitude = c.toString(),
                    longitude = c.toString(),
                    offset = c.toString(),
                    description = c.toString(),
                    email = c.toString(),
                    username = c.toString(),
                    birthdate = "1975-07-30T21:07:58.453Z",
                    age = index,
                    dateRegistered = "1975-07-30T21:07:58.453Z",
                    ageRegistered = index,
                    idName = c.toString(),
                    idValue = c.toString()
                )
            )
        }
        usersToAdd.shuffle()

        testUser = usersToAdd[10]

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