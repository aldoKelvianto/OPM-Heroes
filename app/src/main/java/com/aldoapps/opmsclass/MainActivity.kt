package com.aldoapps.opmsclass

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.aldoapps.opmsclass.databinding.ActivityMainBinding
import com.aldoapps.opmsclass.herolist.HeroViewModel

class MainActivity : AppCompatActivity() {

    private var binding: ActivityMainBinding? = null

    private var heroViewModel: HeroViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        setSupportActionBar(binding?.toolbar)

        initViewModel()
        binding?.fab?.setOnClickListener { fetchHeroData() }
    }

    private fun initViewModel() {
        heroViewModel = ViewModelProviders.of(this).get(HeroViewModel::class.java)
        heroViewModel?.hero?.observe(this, Observer {
            it?.let { hero ->
                heroViewModel?.bindData(hero)
            }
        })
        binding?.contentMain?.heroViewModel = heroViewModel
    }

    private fun fetchHeroData() {
        heroViewModel?.fetchDataForMePlease()
    }

}
