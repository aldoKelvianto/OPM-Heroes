package com.aldoapps.opmsclass.quote.interactor

/**
 * Created by aldo on 04/02/18.
 */
interface GetRandomQuoteCallback<in T> {

  fun onFinished(quote: T)
}