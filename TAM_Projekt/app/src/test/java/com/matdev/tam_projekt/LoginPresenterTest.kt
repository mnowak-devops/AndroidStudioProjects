package com.matdev.tam_projekt

import com.matdev.tam_projekt.Presenter.LoginInteractor
import com.matdev.tam_projekt.Presenter.LoginPresenter
import com.matdev.tam_projekt.View.LoginView
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify

/*
Testy jednostkowe testują tylko i wyłącznie logikę, nieopartą w żaden sposób na elementach systemu
Android, zatem są to stricte klasy logiczne (nie zawierające importów do klas android.*).
 */
class LoginPresenterTest {

    /*
    Definiujemy zmienną na klasę, którą zamierzamy testować
     */
    private lateinit var loginPresenter: LoginPresenter

    /*
    Za pomocą @Mock definiujemy mock (obiekt zastępczy) dla zależności naszej testowanej klasy.
    Z racji, że LoginPresenter przyjmuje w konstruktorze zarówno LoginView jak i LoginInteractor,
    to musimy podać obydwa mocki, żeby nie pisać implementacji tych klas specjalnie pod testy
    (bo klasa testowa nie musi wiedzieć, z czego składają się mocki - taka idea tych zależności).
    Mocki w testach z reguły mają nazwę klasa + mock, jak widać niżej.
     */
    @Mock
    private lateinit var loginViewMock: LoginView

    /*
    Analogicznie jak powyżej.
     */
    @Mock
    private lateinit var loginInteractorMock: LoginInteractor

    /*
    @Before określa co ma się stać przed każdym wywołaniem funkcji oznaczonej przez @Test. Tutaj
    musimy zainicjalizować wszelkie wymagane zależności wymagane dla naszej testowanej klasy.
    W tym przypadku inicjalizujemy poprzez mock() nasze mocki i później przekazujemy je do
    loginPresenter, po prostu tworząc go, ale wykorzystując mocki zamiast faktyczne obiekty.
     */
    @Before
    fun before() {
        //Inicjalizujemy mocki
        loginViewMock = mock(LoginView::class.java)
        loginInteractorMock = mock(LoginInteractor::class.java)

        //Na koniec tworzymy nasz obiekt testowy, wykorzystując mocki.
        loginPresenter = LoginPresenter(loginViewMock, loginInteractorMock)
    }

    /*
    Przykładowy @Test. Zawsze w testach jednostkowych chodzi o to, że wywołujemy jakąkolwiek
    publiczną funkcję z testowanej klasy i sprawdzamy oczekiwany efekt. W tym przypadku wywołanie
    metody onLoginError z klasy LoginPresenter powinno wywołać metodę onLoginError ale w klasie
    LoginView - zgodnie z tym co zostało zaimplementowane w faktycznym pliku.
    Nazwa metody jest dowolna, aczkolwiek powinna mniejwięcej podpowiadać co tu jest testowane.
     */
    @Test
    fun onLoginError_powinno_wywolac_loginView_onLoginError() {
        //Co testujemy (tutaj: metoda onLoginError w naszej testowanej klasie)
        loginPresenter.onLoginError()

        //Sprawdzamy czy nasza klasa wywołała to co trzeba (tutaj: metodę onLoginError w LoginView)
        verify(loginViewMock).onLoginError()
    }
}