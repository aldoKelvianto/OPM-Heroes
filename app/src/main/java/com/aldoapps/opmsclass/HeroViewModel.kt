package com.aldoapps.opmsclass

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.MutableLiveData
import android.os.AsyncTask

/**
 * Created by aldo on 04/01/18.
 */
class HeroViewModel(application: Application) : AndroidViewModel(application) {

    val hero: MutableLiveData<Hero> = MutableLiveData()
    var name: String? = "Saitama"
    var photo: Int = R.mipmap.ic_launcher_round
    var rank: String = "0"
    var isLoading = false

    interface Callback<in T> {
        fun onFinished(hero: T)
    }

    init {
        hero.observeForever({
            it?.let { hero ->
                bindData(hero)
            }
        })
        isLoading = true
    }

    fun fetchDataForMePlease() {
        isLoading = true

        HeroViewModel.HeroFetcher(HeroDatabase, object : HeroViewModel.Callback<Hero> {
            override fun onFinished(hero: Hero) {
                isLoading = false
                this@HeroViewModel.hero.value = hero
            }
        }).execute("Blast")
    }

    private fun bindData(hero: Hero) {
        name = hero.name
        photo = hero.photo
        rank = hero.rank.toString()
    }

    class HeroFetcher(private val heroDb: HeroDatabase, private val callback: Callback<Hero>) : AsyncTask<String, Int, Hero>() {
        override fun doInBackground(vararg params: String?): Hero {
            val heroName = params[0] ?: "Blast"
            return heroDb.getHero(heroName) ?: heroDb.getDefaultHero()
        }

        override fun onPostExecute(hero: Hero) {
            callback.onFinished(hero)
        }

    }
}