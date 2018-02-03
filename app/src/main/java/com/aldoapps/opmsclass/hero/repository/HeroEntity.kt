package com.aldoapps.opmsclass.hero.repository

import com.aldoapps.opmsclass.hero.ui.HeroModel

/**
 * Created by aldo on 04/01/18.
 */
data class HeroEntity(val name: String, val alias: String, val photo: Int, val rank: Int, val description: String)

fun HeroEntity.toHeroModel(): HeroModel =
        HeroModel(alias,
                photo,
                rank.toString())