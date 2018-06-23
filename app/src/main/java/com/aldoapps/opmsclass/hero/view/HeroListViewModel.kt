package com.aldoapps.opmsclass.hero.view

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.aldoapps.opmsclass.hero.interactor.GetHeroList
import com.aldoapps.opmsclass.hero.interactor.GetHeroListCallback
import com.aldoapps.opmsclass.hero.repository.HeroDatabase
import com.aldoapps.opmsclass.hero.repository.HeroEntity
import com.aldoapps.opmsclass.hero.util.HeroModelMapper

/**
 * Created by aldo on 04/01/18.
 */
class HeroListViewModel(application: Application) : AndroidViewModel(application), GetHeroListCallback<List<HeroEntity>> {

    val heroListLiveData: MutableLiveData<List<HeroModel>> = MutableLiveData()

    var isLoading = MutableLiveData<Boolean>()

    private fun getHeroListUseCase() = GetHeroList(HeroDatabase, this)

    init {
        isLoading.value = true
    }

    fun getHeroList() {
        isLoading.value = true
        getHeroListUseCase().execute()
    }

    override fun onFinished(heroList: List<HeroEntity>) {
        isLoading.value = false
        heroListLiveData.value = HeroModelMapper.transformHeroEntities(heroList)
    }
}