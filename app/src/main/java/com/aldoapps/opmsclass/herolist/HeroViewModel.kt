package com.aldoapps.opmsclass.herolist

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.MutableLiveData
import android.databinding.ObservableBoolean
import android.databinding.ObservableField
import android.databinding.ObservableInt

/**
 * Created by aldo on 04/01/18.
 */
class HeroViewModel(application: Application) : AndroidViewModel(application) {

    val hero: MutableLiveData<Hero> = MutableLiveData()
    var name = ObservableField<String>()
    var photo = ObservableInt()
    var rank = ObservableField<String>()
    var isLoading = ObservableBoolean()

    init {
        isLoading.set(true)
    }

    fun fetchDataForMePlease() {
        isLoading.set(true)

        GetHero(HeroDatabase, object : Callback<Hero> {
            override fun onFinished(hero: Hero) {
                isLoading.set(false)

                this@HeroViewModel.hero.value = hero
            }
        }).execute("Blast")
    }

    fun bindData(hero: Hero) {
        name.set(hero.name)
        photo.set(hero.photo)
        rank.set(hero.rank.toString())
    }
}