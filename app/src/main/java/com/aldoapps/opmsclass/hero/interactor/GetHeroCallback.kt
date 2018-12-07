package com.aldoapps.opmsclass.hero.interactor

/**
 * Created by aldo on 04/02/18.
 */
interface GetHeroCallback<in T> {
  fun onFinished(hero: T)
}