package com.aldoapps.opmsclass.herolist

import android.os.AsyncTask

/**
 * Created by aldo on 31/01/18.
 */
class GetHero(private val heroDb: HeroDatabase, private val callback: Callback<Hero>) : AsyncTask<String, Int, Hero>() {

    override fun doInBackground(vararg params: String?): Hero {
        val heroName = params[0] ?: "Blast"
        return heroDb.getHero(heroName) ?: heroDb.getDefaultHero()
    }

    override fun onPostExecute(hero: Hero) {
        callback.onFinished(hero)
    }

}