package com.matdev.tam_projekt

import com.matdev.tam_projekt.Presenter.LoginInteractor
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.mock

class LoginInteractorTest {
    private lateinit var cut: LoginInteractor

    @Before
    fun setUp() {
        cut = LoginInteractor()
    }

    @Test
    fun `Given _ when canLogin then _`() {
        // Given
        val username = "username"
        val password = "password"
        val listener = mock(LoginInteractor.OnLoginFinishedListener::class.java)

        // When
        cut.canLogin(username, password, listener)

        // Then
        TODO("Define assertions")
    }

    @Test(expected = Exception::class)
    fun `Given _ when canLogin then throws exception`() {
        // Given
        val username = "username"
        val password = "password"
        val listener = mock(LoginInteractor.OnLoginFinishedListener::class.java)

        // When
        cut.canLogin(username, password, listener)

        // Then
        // Exception is thrown
    }
}
