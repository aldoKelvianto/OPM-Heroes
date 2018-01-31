package com.aldoapps.opmsclass.herolist

/**
 * Created by aldo on 31/01/18.
 */
interface Callback<in T> {
    fun onFinished(hero: T)
}