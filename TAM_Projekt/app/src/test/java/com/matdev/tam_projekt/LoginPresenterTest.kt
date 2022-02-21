package com.matdev.tam_projekt

import com.matdev.tam_projekt.Presenter.LoginInteractor
import com.matdev.tam_projekt.Presenter.LoginPresenter
import com.matdev.tam_projekt.View.LoginView
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify

class LoginPresenterTest {

    @Mock
    private lateinit var loginPresenter: LoginPresenter


    @Mock
    private lateinit var loginViewMock: LoginView

    /*
    Analogicznie jak powyżej.
     */
    @Mock
    private lateinit var loginInteractorMock: LoginInteractor


    @Before
    fun before() {
        //Inicjalizujemy mocki
        loginViewMock = mock(LoginView::class.java)
        loginInteractorMock = mock(LoginInteractor::class.java)

        //Na koniec tworzymy nasz obiekt testowy, wykorzystując mocki.
        loginPresenter = LoginPresenter(loginViewMock, loginInteractorMock)
    }

    @Test
    fun onLoginError_powinno_wywolac_loginView_onLoginError() {
        //Co testujemy (tutaj: metoda onLoginError w naszej testowanej klasie)
        loginPresenter.onLoginError()

        //Sprawdzamy czy nasza klasa wywołała to co trzeba (tutaj: metodę onLoginError w LoginView)
        verify(loginViewMock).onLoginError()
    }
}