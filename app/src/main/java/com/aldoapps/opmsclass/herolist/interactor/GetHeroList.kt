package com.aldoapps.opmsclass.herolist.interactor

import android.os.AsyncTask
import com.aldoapps.opmsclass.herolist.repository.HeroDatabase
import com.aldoapps.opmsclass.herolist.repository.HeroEntity

/**
 * Created by aldo on 31/01/18.
 */
class GetHeroList(private val heroDb: HeroDatabase, private val callback: Callback<List<HeroEntity>>) : AsyncTask<String, Int, List<HeroEntity>>() {

    override fun doInBackground(vararg params: String?): List<HeroEntity> {
        return heroDb.getHeroList()
    }

    override fun onPostExecute(hero: List<HeroEntity>) {
        callback.onFinished(hero)
    }

}