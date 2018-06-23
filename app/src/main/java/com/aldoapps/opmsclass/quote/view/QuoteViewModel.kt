package com.aldoapps.opmsclass.quote.view

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.aldoapps.opmsclass.quote.interactor.GetRandomQuote
import com.aldoapps.opmsclass.quote.interactor.GetRandomQuoteCallback
import com.aldoapps.opmsclass.quote.repository.QuoteDatabase
import com.aldoapps.opmsclass.quote.repository.QuoteEntity
import com.aldoapps.opmsclass.quote.util.QuoteModelMapper

/**
 * Created by aldo on 04/01/18.
 */
class QuoteViewModel(application: Application) : AndroidViewModel(application), GetRandomQuoteCallback<QuoteEntity> {

    val quoteModelLiveData: MutableLiveData<QuoteModel> = MutableLiveData()

    private fun getRandomQuoteUseCase() = GetRandomQuote(QuoteDatabase, this)

    fun getRandomQuote() {
        getRandomQuoteUseCase().execute()
    }

    override fun onFinished(quote: QuoteEntity) {
        quoteModelLiveData.value = QuoteModelMapper.transformQuoteEntity(quote)

    }
}