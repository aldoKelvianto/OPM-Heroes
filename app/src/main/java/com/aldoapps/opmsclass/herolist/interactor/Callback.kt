package com.aldoapps.opmsclass.herolist.interactor

/**
 * Created by aldo on 31/01/18.
 */
interface Callback<in T> {
    fun onFinished(heroList: T)
}