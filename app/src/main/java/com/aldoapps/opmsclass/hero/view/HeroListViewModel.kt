package com.aldoapps.opmsclass.hero.view

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.MutableLiveData
import android.databinding.ObservableBoolean
import com.aldoapps.opmsclass.hero.interactor.GetHeroListCallback
import com.aldoapps.opmsclass.hero.interactor.GetHeroList
import com.aldoapps.opmsclass.hero.repository.HeroDatabase
import com.aldoapps.opmsclass.hero.repository.HeroEntity
import com.aldoapps.opmsclass.hero.util.HeroModelMapper

/**
 * Created by aldo on 04/01/18.
 */
class HeroListViewModel(application: Application) : AndroidViewModel(application), GetHeroListCallback<List<HeroEntity>> {

    val heroListLiveData: MutableLiveData<List<HeroModel>> = MutableLiveData()

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
        heroListLiveData.value = HeroModelMapper.transformHeroEntities(heroList)
    }
}