package com.aldoapps.opmsclass.herolist.ui

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.MutableLiveData
import android.databinding.ObservableBoolean
import com.aldoapps.opmsclass.herolist.interactor.Callback
import com.aldoapps.opmsclass.herolist.interactor.GetHero
import com.aldoapps.opmsclass.herolist.repository.HeroDatabase
import com.aldoapps.opmsclass.herolist.repository.HeroEntity

/**
 * Created by aldo on 04/01/18.
 */
class HeroViewModel(application: Application) : AndroidViewModel(application), Callback<HeroEntity> {

    val heroEntity: MutableLiveData<HeroEntity> = MutableLiveData()
    var isLoading = ObservableBoolean()

    private fun getHero() = GetHero(HeroDatabase, this)

    init {
        isLoading.set(true)
    }

    fun queryHeroList() {
        isLoading.set(true)
        getHero().execute("Blast")
    }

    override fun onFinished(hero: HeroEntity) {
        isLoading.set(false)
        heroEntity.value = hero
    }
}