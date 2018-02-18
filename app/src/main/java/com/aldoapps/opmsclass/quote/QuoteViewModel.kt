package com.aldoapps.opmsclass.quote

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.Observer
import android.databinding.ObservableField
import com.aldoapps.opmsclass.quote.interactor.GetRandomQuote
import com.aldoapps.opmsclass.quote.interactor.GetRandomQuoteCallback
import com.aldoapps.opmsclass.quote.repository.QuoteDatabase
import com.aldoapps.opmsclass.quote.repository.QuoteEntity

/**
 * Created by aldo on 04/01/18.
 */
class QuoteViewModel(application: Application) : AndroidViewModel(application), GetRandomQuoteCallback<QuoteEntity> {

    val quoteEntityLiveData: MutableLiveData<QuoteEntity> = MutableLiveData()

    val author = ObservableField<String>()
    val quote = ObservableField<String>()

    private fun getQuote() = GetRandomQuote(QuoteDatabase, this)

    fun getRandomQuote() {
        getQuote().execute()
    }

    override fun onFinished(quote: QuoteEntity) {
        quoteEntityLiveData.value = quote
    }

}