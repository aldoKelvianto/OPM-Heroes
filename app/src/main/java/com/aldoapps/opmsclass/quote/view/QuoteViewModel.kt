package com.aldoapps.opmsclass.quote.view

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.aldoapps.opmsclass.quote.interactor.GetRandomQuote
import com.aldoapps.opmsclass.quote.repository.QuoteDatabase
import com.aldoapps.opmsclass.quote.util.QuoteModelMapper

/**
 * Created by aldo on 04/01/18.
 */
class QuoteViewModel : ViewModel() {

  val quoteLiveData: MutableLiveData<QuoteModel> = MutableLiveData()

  private fun getRandomQuoteUseCase() = GetRandomQuote(QuoteDatabase) {
    quoteLiveData.value = QuoteModelMapper.transformQuoteEntity(it)
  }

  fun getRandomQuote() {
    getRandomQuoteUseCase().execute()
  }
}