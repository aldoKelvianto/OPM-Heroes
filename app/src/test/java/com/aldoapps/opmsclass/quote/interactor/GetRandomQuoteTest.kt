package com.aldoapps.opmsclass.quote.interactor

import com.aldoapps.opmsclass.quote.repository.QuoteDatabase
import com.aldoapps.opmsclass.quote.repository.QuoteEntity
import com.aldoapps.opmsclass.util.any
import com.aldoapps.opmsclass.util.capture
import org.assertj.core.api.Assertions.assertThat
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.ArgumentCaptor
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnit
import org.mockito.junit.MockitoRule
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

/**
 * Created by aldo on 02/02/18.
 */
@RunWith(RobolectricTestRunner::class)
@Config(sdk = [25])
class GetRandomQuoteTest {

    private lateinit var quoteDatabase: QuoteDatabase

    @get:Rule
    val mockitoRule: MockitoRule = MockitoJUnit.rule()

    @Mock
    private lateinit var mockGetRandomQuoteCallback: GetRandomQuoteCallback<QuoteEntity>

    @Before
    fun setup() {
        quoteDatabase = QuoteDatabase
    }

    @Test
    fun shouldReturnValidQuote_whenGetRandomQuoteFromDb() {
        GetRandomQuote(quoteDatabase, object : GetRandomQuoteCallback<QuoteEntity> {
            override fun onFinished(quote: QuoteEntity) {
                assertThat(quote).isNotNull()
                        .hasFieldOrProperty("hero")
                        .hasFieldOrProperty("quote")
            }
        }).execute()
    }

    @Test
    fun shouldTriggerCallback_whenGetRandomQuoteFromDb() {
        // Given
        val captor: ArgumentCaptor<QuoteEntity> = ArgumentCaptor.forClass(QuoteEntity::class.java)

        // When
        GetRandomQuote(quoteDatabase, mockGetRandomQuoteCallback).execute()

        // Then
        // captor.capture() will throw IllegalStateException
        // java.lang.IllegalStateException: captor.capture() must not be null
        // Mockito.verify(mockGetRandomQuoteCallback).onFinished(captor.capture())
        Mockito.verify(mockGetRandomQuoteCallback).onFinished(capture(captor))
        assertThat(captor.value).isNotNull()
                .hasFieldOrProperty("hero")
                .hasFieldOrProperty("quote")
        Mockito.verifyNoMoreInteractions(mockGetRandomQuoteCallback)
    }
}