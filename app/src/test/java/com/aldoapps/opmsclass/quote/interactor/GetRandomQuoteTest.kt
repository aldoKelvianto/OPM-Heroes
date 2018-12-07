package com.aldoapps.opmsclass.quote.interactor

import com.aldoapps.opmsclass.quote.repository.QuoteDatabase
import org.assertj.core.api.Assertions.assertThat
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
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

  @Before
  fun setup() {
    quoteDatabase = QuoteDatabase
  }

  @Test
  fun shouldReturnValidQuote_whenGetRandomQuoteFromDb() {
    GetRandomQuote(quoteDatabase) {
      assertThat(it).isNotNull()
          .hasFieldOrProperty("hero")
          .hasFieldOrProperty("quote")
    }.execute()
  }
}