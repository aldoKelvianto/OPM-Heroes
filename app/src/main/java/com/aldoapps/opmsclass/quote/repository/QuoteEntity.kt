package com.aldoapps.opmsclass.quote.repository

import com.aldoapps.opmsclass.hero.repository.HeroEntity

/**
 * Created by aldo on 05/01/18.
 */
data class QuoteEntity(val hero: HeroEntity, val quote: String)
