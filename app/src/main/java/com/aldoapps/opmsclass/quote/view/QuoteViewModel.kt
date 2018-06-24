package com.aldoapps.opmsclass.quote.view

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.aldoapps.opmsclass.quote.interactor.GetRandomQuote
import com.aldoapps.opmsclass.quote.interactor.GetRandomQuoteCallback
import com.aldoapps.opmsclass.quote.repository.QuoteDatabase
import com.aldoapps.opmsclass.quote.repository.QuoteEntity
import com.aldoapps.opmsclass.quote.util.QuoteModelMapper

/**
 * Created by aldo on 04/01/18.
 */
class QuoteViewModel : ViewModel(), GetRandomQuoteCallback<QuoteEntity> {

    val quoteLiveData: MutableLiveData<QuoteModel> = MutableLiveData()

    private fun getRandomQuoteUseCase() = GetRandomQuote(QuoteDatabase, this)

    fun getRandomQuote() {
        getRandomQuoteUseCase().execute()
    }

    override fun onFinished(quote: QuoteEntity) {
        quoteLiveData.value = QuoteModelMapper.transformQuoteEntity(quote)
    }
}