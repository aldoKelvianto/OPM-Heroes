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
class HeroViewModel(application: Application) : AndroidViewModel(application), Callback<HeroEntity> {

    val heroEntity: MutableLiveData<HeroEntity> = MutableLiveData()
    var name = ObservableField<String>()
    var photo = ObservableInt()
    var rank = ObservableField<String>()
    var isLoading = ObservableBoolean()

    private val getHero by lazy {
        GetHero(HeroDatabase, this)
    }

    init {
        isLoading.set(true)
    }

    fun fetchDataForMePlease() {
        isLoading.set(true)
        getHero.execute("Blast")
    }

    fun bindData(hero: HeroModel) {
        name.set(hero.alias)
        photo.set(hero.photo)
        rank.set(hero.rank.toString())
    }

    override fun onFinished(hero: HeroEntity) {
        isLoading.set(false)
        heroEntity.value = hero
    }
}