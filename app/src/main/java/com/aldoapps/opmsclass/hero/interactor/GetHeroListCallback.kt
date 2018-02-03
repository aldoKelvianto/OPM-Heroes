package com.aldoapps.opmsclass.hero.interactor

/**
 * Created by aldo on 31/01/18.
 */
interface GetHeroListCallback<in T> {
    fun onFinished(heroList: T)
}