package com.aldoapps.opmsclass.quote.repository

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.catchThrowable
import org.junit.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

/**
 * Created by aldo on 05/01/18.
 */
class QuoteDatabaseTest {

    @Test
    fun shouldHave33Quotes_whenGetQuotesFromQuoteDatabase() {
        // Given
        // When
        val quotes = QuoteDatabase.getQuotes()
        // Then
        assertThat(quotes.size).isEqualTo(33)
    }

    @Test
    fun shouldReturnValidQuote_whenGetQuoteFromDatabase() {
        // Given
        // When
        val quotes = QuoteDatabase.getQuotes()
        val randomQuote = QuoteDatabase.getRandomQuote()

        // Then
        assertThat(randomQuote).isNotNull()
        assertThat(randomQuote.hero).isNotNull()
        assertThat(randomQuote.quote).isNotEmpty()
        assertThat(quotes).contains(randomQuote)
    }

    @Test
    fun shouldThrowException_whenIndexIsOutOfBound() {
        // Given
        val size = QuoteDatabase.getQuotes().size

        // When
        val throwable = catchThrowable {
            QuoteDatabase.getQuotes()[size]
        }

        // Then
        assertThat(throwable).isNotNull()
                .isInstanceOf(ArrayIndexOutOfBoundsException::class.java)
    }

    @Test
    fun shouldReturnValidQuote_whenGetQuotesByAuthor() {
        // Given
        // When
        val tatsumakiQuotes = QuoteDatabase.getQuotesByAuthor("Tatsumaki")

        // Then
        assertThat(tatsumakiQuotes).hasSize(1)
        assertThat(tatsumakiQuotes.first().hero.name).isEqualToIgnoringCase("TATSUMAKI")

        // When
        val kingQuotes = QuoteDatabase.getQuotesByAuthor("KING");
        // Then
        assertThat(kingQuotes).hasSize(2)
        assertThat(kingQuotes.first().quote).isEqualTo("Romance games are my oasis.")

        // When
        val saitamaQuotes = QuoteDatabase.getQuotesByAuthor("Saitama")
        assertThat(saitamaQuotes).hasSize(11)
        assertThat(saitamaQuotes.first().hero.name).isEqualToIgnoringCase("saiTAMA")
    }

    @ParameterizedTest
    @CsvSource(
            "Tatsumaki, 1",
            "King, 2",
            "Saitama, 11"
    )
    fun shouldReturnValidQuotesSize_whenGetQuotesByAuthor(author: String, expected: Int) {
        val quote = QuoteDatabase.getQuotesByAuthor(author)
        assertThat(quote).hasSize(expected)
    }
}