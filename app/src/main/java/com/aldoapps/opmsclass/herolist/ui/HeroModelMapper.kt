package com.aldoapps.opmsclass.herolist.ui

import com.aldoapps.opmsclass.herolist.repository.HeroEntity
import com.aldoapps.opmsclass.herolist.repository.toHeroModel

/**
 * Created by aldo on 01/02/18.
 */
object HeroModelMapper {

    fun transformHeroEntity(list: List<HeroEntity>): List<HeroModel> =
            list.flatMap {
                listOf(it.toHeroModel())
            }
}