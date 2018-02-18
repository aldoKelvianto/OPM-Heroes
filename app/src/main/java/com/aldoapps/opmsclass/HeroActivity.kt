package com.aldoapps.opmsclass

import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.aldoapps.opmsclass.databinding.ActivityMainBinding
import com.aldoapps.opmsclass.hero.view.HeroAdapter
import com.aldoapps.opmsclass.hero.view.HeroListViewModel
import com.aldoapps.opmsclass.quote.QuoteViewModel
import kotlinx.android.synthetic.main.content_main.*

class HeroActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var heroListViewModel: HeroListViewModel

    private lateinit var quoteViewModel: QuoteViewModel

    private lateinit var adapter: HeroAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initViewModel()
        initBinding()
        initRecyclerView()
        refreshQuote(null)
        fetchHeroData()
    }

    private fun initBinding() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.let {
            binding.contentMain?.heroListViewModel = heroListViewModel
            binding.contentMain?.quoteViewModel = quoteViewModel
            binding.setLifecycleOwner(this)
        }
    }

    private fun initRecyclerView() {
        rv_hero.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        rv_hero.setHasFixedSize(true)
        adapter = HeroAdapter()
        rv_hero.adapter = adapter
    }

    private fun initViewModel() {
        heroListViewModel = ViewModelProviders.of(this).get(HeroListViewModel::class.java)
        quoteViewModel = ViewModelProviders.of(this).get(QuoteViewModel::class.java)
    }

    fun refreshQuote(view: View?) {
        quoteViewModel.getRandomQuote()
    }

    fun fetchHeroData() {
        heroListViewModel.queryHeroList()
    }
}
