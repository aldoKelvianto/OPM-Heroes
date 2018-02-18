package com.aldoapps.opmsclass.quote.util

import com.aldoapps.opmsclass.quote.repository.QuoteEntity
import com.aldoapps.opmsclass.quote.view.QuoteModel

/**
 * Created by aldo on 18/02/18.
 */
object QuoteModelMapper {

    fun transformQuoteEntity(it: QuoteEntity): QuoteModel = QuoteModel(it.hero.name, it.quote)
}