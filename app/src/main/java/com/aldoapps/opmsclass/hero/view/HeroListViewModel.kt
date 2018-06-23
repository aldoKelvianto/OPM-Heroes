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

    val heroList: LiveData<List<HeroModel>>
        get() = _heroListLiveData

    val isLoading: LiveData<Boolean>
        get() = _isLoading

    private val _heroListLiveData: MutableLiveData<List<HeroModel>> = MutableLiveData()

    private val _isLoading = MutableLiveData<Boolean>()

    private fun getHeroListUseCase() = GetHeroList(HeroDatabase, this)

    init {
        _isLoading.value = true
    }

    fun getHeroList() {
        _isLoading.value = true
        getHeroListUseCase().execute()
    }

    override fun onFinished(heroList: List<HeroEntity>) {
        _isLoading.value = false
        _heroListLiveData.value = HeroModelMapper.transformHeroEntities(heroList)
    }
}