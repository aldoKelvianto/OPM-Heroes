package com.aldoapps.opmsclass

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.aldoapps.opmsclass.databinding.ActivityHeroBinding
import com.aldoapps.opmsclass.hero.view.HeroAdapter
import com.aldoapps.opmsclass.hero.view.HeroListViewModel
import com.aldoapps.opmsclass.quote.view.QuoteViewModel

class HeroActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHeroBinding

    private lateinit var heroListViewModel: HeroListViewModel

    private lateinit var quoteViewModel: QuoteViewModel

    private lateinit var adapter: HeroAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initViewModel()
        initBinding()
        initRecyclerView()
        quoteViewModel.getRandomQuote()
        getHeroList()
    }

    private fun initBinding() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_hero)
        binding.setLifecycleOwner(this)
        binding.contentHero.heroListViewModel = heroListViewModel
        binding.contentHero.quoteViewModel = quoteViewModel
    }

    private fun initRecyclerView() {
        binding.contentHero.rvHero.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.contentHero.rvHero.setHasFixedSize(true)
        adapter = HeroAdapter()
        binding.contentHero.rvHero.adapter = adapter
    }

    private fun initViewModel() {
        heroListViewModel = ViewModelProviders.of(this)
                .get(HeroListViewModel::class.java)
        quoteViewModel = ViewModelProviders.of(this)
                .get(QuoteViewModel::class.java)
    }

    fun refreshQuote(v: View) {
        quoteViewModel.getRandomQuote()
    }

    private fun getHeroList() {
        heroListViewModel.getHeroList()
    }
}
