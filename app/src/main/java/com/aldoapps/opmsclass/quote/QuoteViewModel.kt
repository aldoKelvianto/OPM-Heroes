package com.aldoapps.opmsclass.quote

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.MutableLiveData
import com.aldoapps.opmsclass.quote.interactor.GetRandomQuote
import com.aldoapps.opmsclass.quote.interactor.GetRandomQuoteCallback
import com.aldoapps.opmsclass.quote.repository.QuoteDatabase
import com.aldoapps.opmsclass.quote.repository.QuoteEntity
import com.aldoapps.opmsclass.quote.util.QuoteModelMapper
import com.aldoapps.opmsclass.quote.view.QuoteModel

/**
 * Created by aldo on 04/01/18.
 */
class QuoteViewModel(application: Application) : AndroidViewModel(application), GetRandomQuoteCallback<QuoteEntity> {

    val quoteEntityLiveData: MutableLiveData<QuoteModel> = MutableLiveData()

    private fun getQuote() = GetRandomQuote(QuoteDatabase, this)

    fun getRandomQuote() {
        getQuote().execute()
    }

    override fun onFinished(quote: QuoteEntity) {
        quoteEntityLiveData.value = QuoteModelMapper.transformQuoteEntity(quote)
    }

}