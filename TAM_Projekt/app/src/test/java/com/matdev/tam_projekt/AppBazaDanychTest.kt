package com.matdev.tam_projekt

import com.matdev.tam_projekt.Model.AppBazaDanych
import org.junit.Before
import org.mockito.Mockito.mock


class AppBazaDanychTest {
    private lateinit var cut: AppBazaDanych

    @Before
    fun setUp() {
        cut = mock(AppBazaDanych::class.java)
    }

}
