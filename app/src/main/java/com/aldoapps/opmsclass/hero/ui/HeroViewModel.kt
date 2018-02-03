package com.aldoapps.opmsclass.hero.ui

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.MutableLiveData
import android.databinding.ObservableBoolean
import com.aldoapps.opmsclass.hero.interactor.GetHeroListCallback
import com.aldoapps.opmsclass.hero.interactor.GetHeroList
import com.aldoapps.opmsclass.hero.repository.HeroDatabase
import com.aldoapps.opmsclass.hero.repository.HeroEntity

/**
 * Created by aldo on 04/01/18.
 */
class HeroViewModel(application: Application) : AndroidViewModel(application), GetHeroListCallback<List<HeroEntity>> {

    val heroListEntity: MutableLiveData<List<HeroEntity>> = MutableLiveData()
    var isLoading = ObservableBoolean()

    private fun getHero() = GetHeroList(HeroDatabase, this)

    init {
        isLoading.set(true)
    }

    fun queryHeroList() {
        isLoading.set(true)
        getHero().execute()
    }

    override fun onFinished(heroList: List<HeroEntity>) {
        isLoading.set(false)
        heroListEntity.value = heroList
    }
}