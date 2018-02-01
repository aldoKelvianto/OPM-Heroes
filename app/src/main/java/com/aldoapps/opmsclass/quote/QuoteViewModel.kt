package com.aldoapps.opmsclass.quote

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.databinding.ObservableField

/**
 * Created by aldo on 04/01/18.
 */
class QuoteViewModel(application: Application) : AndroidViewModel(application) {

    private val quoteLiveData: LiveData<Quote> = MutableLiveData()

    val author = ObservableField<String>()
    val quote = ObservableField<String>()


}