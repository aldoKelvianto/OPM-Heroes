package com.aldoapps.opmsclass.herolist.ui

import com.aldoapps.opmsclass.herolist.repository.HeroEntity

/**
 * Created by aldo on 01/02/18.
 */
object HeroModelMapper {

    fun transformHeroEntity(heroEntity: HeroEntity): HeroModel =
            HeroModel(heroEntity.alias,
                    heroEntity.photo,
                    heroEntity.rank.toString())
}