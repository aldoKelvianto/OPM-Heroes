package com.aldoapps.opmsclass.quote.interactor

import android.os.AsyncTask
import com.aldoapps.opmsclass.quote.repository.QuoteDatabase
import com.aldoapps.opmsclass.quote.repository.QuoteEntity

/**
 * Created by aldo on 04/02/18.
 */
class GetRandomQuote(
  private val quoteDb: QuoteDatabase,
  private val callback: GetRandomQuoteCallback<QuoteEntity>
) : AsyncTask<Void, Void, QuoteEntity>() {

  override fun doInBackground(vararg params: Void?): QuoteEntity {
    return quoteDb.getRandomQuote()
  }

  override fun onPostExecute(result: QuoteEntity) {
    callback.onFinished(result)
  }
}