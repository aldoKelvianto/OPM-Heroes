package com.aldoapps.opmsclass.herolist

/**
 * Created by aldo on 01/02/18.
 */
object HeroModelMapper {

    fun transformHeroEntity(heroEntity: HeroEntity): HeroModel =
            HeroModel(heroEntity.alias,
                    heroEntity.photo,
                    heroEntity.rank)
}