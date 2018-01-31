package com.aldoapps.opmsclass.com.aldoapps.opmsclass.quote

import com.aldoapps.opmsclass.quote.QuoteDatabase
import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertTrue
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.text.IsEqualIgnoringCase
import org.junit.Test

/**
 * Created by aldo on 05/01/18.
 */
class QuoteDatabaseTest {

    @Test
    fun getAllQuoteTest() {
        // Given
        // When
        val quotes = QuoteDatabase.getQuotes()
        // Then
        assertEquals(30, quotes.size)
    }

    @Test
    fun getQuotesByAuthorTest() {
        // Given
        // When
        val tatsumakiQuotes = QuoteDatabase.getQuotesByAuthor("Tatsumaki");
        // Then
        assertEquals(1, tatsumakiQuotes.size)
        assertTrue("TATSUMAKI".equals(tatsumakiQuotes.first().author, true))

        // When
        val kingQuotes = QuoteDatabase.getQuotesByAuthor("KING");
        // Then
        assertEquals(2, kingQuotes.size)
        assertEquals("Romance games are my oasis.", kingQuotes.get(1).quote)

        // When
        val saitamaQuotes = QuoteDatabase.getQuotesByAuthor("Saitama")
        assertEquals(11, saitamaQuotes.size)
        assertThat(saitamaQuotes.first().author, IsEqualIgnoringCase("saiTAMA"))
    }
}