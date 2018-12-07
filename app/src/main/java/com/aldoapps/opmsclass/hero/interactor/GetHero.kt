package com.aldoapps.opmsclass.hero.interactor

import android.os.AsyncTask
import com.aldoapps.opmsclass.hero.repository.HeroDatabase
import com.aldoapps.opmsclass.hero.repository.HeroEntity

/**
 * Created by aldo on 04/02/18.
 * TODO: Use it when JetPack Navigation is stable
 */
class GetHero(
  private val heroDb: HeroDatabase,
  private val callback: GetHeroCallback<HeroEntity>
) : AsyncTask<String, Void, HeroEntity>() {

  override fun doInBackground(vararg params: String?): HeroEntity {
    val heroName = params[0]
    return getHeroFromDb(heroName)
  }

  override fun onPostExecute(hero: HeroEntity) {
    callback.onFinished(hero)
  }

  private fun getHeroFromDb(heroName: String?): HeroEntity =
    heroName?.let {
      heroDb.getHero(it) ?: heroDb.getDefaultHero()
    } ?: heroDb.getDefaultHero()
}