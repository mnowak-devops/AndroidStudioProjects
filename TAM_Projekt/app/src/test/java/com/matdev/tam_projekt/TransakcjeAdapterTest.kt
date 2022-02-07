package com.matdev.tam_projekt

import com.matdev.tam_projekt.Model.Transakcje
import com.matdev.tam_projekt.Presenter.TransakcjeAdapter
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.mock

abstract class TransakcjeAdapterTest {
    private lateinit var cut: TransakcjeAdapter

    private  val transakcje: List<Transakcje> = TODO()


    @Before
    fun setUp() {
        cut = TransakcjeAdapter(transakcje)
    }

    @Test
    fun `Given _ when onBindViewHolder then _`() {
        // Given
        val holder = mock(TransakcjeAdapter.TransakcjeHolder::class.java)
        val position = 0

        // When
        cut.onBindViewHolder(holder, position)

        // Then
        TODO("Define assertions")
    }

    @Test(expected = Exception::class)
    fun `Given _ when onBindViewHolder then throws exception`() {
        // Given
        val holder = mock(TransakcjeAdapter.TransakcjeHolder::class.java)
        val position = 0

        // When
        cut.onBindViewHolder(holder, position)

        // Then
        // Exception is thrown
    }

    @Test
    fun `Given _ when getItemCount then _`() {
        // Given

        // When
        val actualValue = cut.getItemCount()

        // Then
        TODO("Define assertions")
    }

    @Test(expected = Exception::class)
    fun `Given _ when getItemCount then throws exception`() {
        // Given

        // When
        cut.getItemCount()

        // Then
        // Exception is thrown
    }

    @Test
    fun `Given _ when setData then _`() {
        // Given
        val transakcje: List<Transakcje> = TODO()

        // When
        cut.setData(transakcje)

        // Then
        TODO("Define assertions")
    }

    @Test(expected = Exception::class)
    fun `Given _ when setData then throws exception`() {
        // Given
        val transakcje: List<Transakcje> = TODO()

        // When
        cut.setData(transakcje)

        // Then
        // Exception is thrown
    }
}
