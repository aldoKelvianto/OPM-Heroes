package com.aldoapps.opmsclass.hero.interactor

import android.os.AsyncTask
import android.os.SystemClock
import com.aldoapps.opmsclass.hero.repository.HeroDatabase
import com.aldoapps.opmsclass.hero.repository.HeroEntity
import com.aldoapps.opmsclass.util.RandomUtil

/**
 * Created by aldo on 31/01/18.
 */
class GetHeroList(
  private val heroDb: HeroDatabase,
  private val getHeroListCallback: GetHeroListCallback<List<HeroEntity>>
) : AsyncTask<Void, Void, List<HeroEntity>>() {
  override fun doInBackground(vararg params: Void?): List<HeroEntity> {
    // Emulate Network Call
    SystemClock.sleep(RandomUtil.getRandomDuration())
    return heroDb.getHeroList()
  }

  override fun onPostExecute(hero: List<HeroEntity>) {
    getHeroListCallback.onFinished(hero)
  }

}