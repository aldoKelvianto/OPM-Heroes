package com.aldoapps.opmsclass.hero.view

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.aldoapps.opmsclass.hero.interactor.GetHeroList
import com.aldoapps.opmsclass.hero.interactor.GetHeroListCallback
import com.aldoapps.opmsclass.hero.repository.HeroDatabase
import com.aldoapps.opmsclass.hero.repository.HeroEntity
import com.aldoapps.opmsclass.hero.util.HeroModelMapper

/**
 * Created by aldo on 04/01/18.
 */
class HeroListViewModel : ViewModel(), GetHeroListCallback<List<HeroEntity>> {

    val heroListLiveData: MutableLiveData<List<HeroModel>> = MutableLiveData()

    // Encapsulation sample, this is unnecessary
    private val _isLoadingLiveData = MutableLiveData<Boolean>()
    val isLoadingLiveData: LiveData<Boolean>
        get() = _isLoadingLiveData

    private fun getHeroListUseCase() = GetHeroList(HeroDatabase, this)

    init {
        _isLoadingLiveData.value = true
    }

    fun getHeroList() {
        _isLoadingLiveData.value = true
        getHeroListUseCase().execute()
    }

    override fun onFinished(heroList: List<HeroEntity>) {
        _isLoadingLiveData.value = false
        heroListLiveData.value = HeroModelMapper.transformHeroEntities(heroList)
    }
}