package com.aldoapps.opmsclass

import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import com.aldoapps.opmsclass.databinding.ActivityMainBinding

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
        binding?.contentMain?.heroViewModel = heroViewModel
    }

    private fun fetchHeroData() {
        heroViewModel?.fetchDataForMePlease()
    }

}
