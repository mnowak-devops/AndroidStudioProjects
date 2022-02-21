package com.matdev.tam_projekt


import com.matdev.tam_projekt.Model.Transakcje
import org.junit.Assert
import org.junit.Test
import org.mockito.Mock
import java.lang.Exception
import kotlin.Throws

class TransakcjeTest {
    @Mock
    private var transakcje = Transakcje(5, "Zakupy Biedronka", 157.20, "Zakupy spożywcze")

    @Test
    @Throws(Exception::class)
    fun testGetId() {
        val result = transakcje.id
        Assert.assertEquals(5, result)
    }

    @Test
    @Throws(Exception::class)
    fun testGetEtykieta() {
        val result = transakcje.etykieta
        Assert.assertEquals("Zakupy Biedronka", result)
    }

    @Test
    @Throws(Exception::class)
    fun testGetIlość() {
        val result = transakcje.ilość
        Assert.assertEquals(157.20, result,0.01)
    }

    @Test
    @Throws(Exception::class)
    fun testGetOpis() {
        val result = transakcje.opis
        Assert.assertEquals("Zakupy spożywcze", result)
    }
    @Mock
    private var transakcje2 = Transakcje(3, "Galeria Zakupy", 200.00, "Spodnie Lancerto")
    @Test
    @Throws(Exception::class)
    fun testComponent1() {
        val result = transakcje2.id
        Assert.assertEquals(3, result.toLong())
    }

    @Test
    @Throws(Exception::class)
    fun testComponent2() {
        val result = transakcje2.etykieta
        Assert.assertEquals("Galeria Zakupy", result)
    }

    @Test
    @Throws(Exception::class)
    fun testComponent3() {
        val result = transakcje2.ilość
        Assert.assertEquals(200.00, result,0.01)
    }

    @Test
    @Throws(Exception::class)
    fun testComponent4() {
        val result = transakcje2.opis
        Assert.assertEquals("Spodnie Lancerto", result)
    }

    @Test
    @Throws(Exception::class)
    fun testCopy() {
        val result = transakcje.copy(4, "Żabka", 16.60, "Cola i czekolada")
        Assert.assertEquals(Transakcje(4, "Żabka", 16.60, "Cola i czekolada"), result)
    }


    @Mock
    private val result1 = this.transakcje == Transakcje(5, "Orlen Paliwo", 180.56, "Tankowanie")

    @Test
    @Throws(Exception::class)
    fun testEquals() {
        val result =this.transakcje == Transakcje(5, "Orlen Paliwo", 180.56, "Tankowanie") == result1
        Assert.assertEquals(true, result)
    }
}