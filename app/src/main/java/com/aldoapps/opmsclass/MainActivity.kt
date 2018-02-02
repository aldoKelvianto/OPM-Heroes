package com.aldoapps.opmsclass

import android.arch.lifecycle.Observer
import android.arch.lifecycle.Transformations
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.aldoapps.opmsclass.databinding.ActivityMainBinding
import com.aldoapps.opmsclass.herolist.ui.HeroAdapter
import com.aldoapps.opmsclass.herolist.ui.HeroModelMapper
import com.aldoapps.opmsclass.herolist.ui.HeroViewModel
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var heroViewModel: HeroViewModel

    private lateinit var adapter: HeroAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        setSupportActionBar(binding.toolbar)

        initRecyclerView()
        initViewModel()
        binding.fab.setOnClickListener { fetchHeroData() }
    }

    private fun initRecyclerView() {
        rv_hero.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        rv_hero.setHasFixedSize(true)
        adapter = HeroAdapter()
        rv_hero.adapter = adapter
    }

    private fun initViewModel() {
        heroViewModel = ViewModelProviders.of(this).get(HeroViewModel::class.java)
        binding.contentMain?.heroViewModel = heroViewModel

        val heroEntity = heroViewModel.heroEntity
        /*
        Transformations.map(heroEntity, {
            HeroModelMapper.transformHeroEntity(it)
        }).observe(this, Observer {
            it ?: return@Observer
            heroViewModel.isLoading.set(false)
//            adapter.add(it)
        })*/
    }

    private fun fetchHeroData() {
        heroViewModel.queryHeroList()
    }
}
