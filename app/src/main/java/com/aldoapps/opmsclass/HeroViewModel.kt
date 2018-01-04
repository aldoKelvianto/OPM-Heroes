package com.aldoapps.opmsclass

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.MutableLiveData
import android.os.AsyncTask

/**
 * Created by aldo on 04/01/18.
 */
class HeroViewModel(application: Application) : AndroidViewModel(application) {

    val name: MutableLiveData<String> = MutableLiveData()
    val photo: MutableLiveData<Int> = MutableLiveData()
    val rank: MutableLiveData<Int> = MutableLiveData()
    val isLoading: MutableLiveData<Boolean> = MutableLiveData()

    interface Callback<T> {
        fun onFinished(hero: T)
    }

    init {
        isLoading.value = true
    }

    fun fetchDataForMePlease() {
        isLoading.value = true

        HeroViewModel.HeroFetcher(HeroDatabase, object : HeroViewModel.Callback<Hero> {
            override fun onFinished(hero: Hero) {
                isLoading.value = false
                bindData(hero)
            }
        }).execute("Blast")
    }

    fun bindData(hero: Hero) {
        name.value = hero.name
        photo.value = hero.photo
        rank.value = hero.rank
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