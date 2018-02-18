package com.aldoapps.opmsclass.hero.util

import com.aldoapps.opmsclass.hero.repository.HeroEntity
import com.aldoapps.opmsclass.hero.repository.toHeroModel
import com.aldoapps.opmsclass.hero.view.HeroModel

/**
 * Created by aldo on 01/02/18.
 */
object HeroModelMapper {

    fun transformHeroEntity(list: List<HeroEntity>): List<HeroModel> =
            list.flatMap {
                listOf(it.toHeroModel())
            }
}