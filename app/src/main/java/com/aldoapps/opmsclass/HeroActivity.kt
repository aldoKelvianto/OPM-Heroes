package com.aldoapps.opmsclass

import android.databinding.DataBindingUtil
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
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
        refreshQuote()
        getHeroList()
    }

    private fun initBinding() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_hero)
        binding.let {
            binding.contentHero.heroListViewModel = heroListViewModel
            binding.contentHero.quoteViewModel = quoteViewModel
            binding.setLifecycleOwner(this)
//            binding.setLifecycleOwner(this)
        }
    }

    private fun initRecyclerView() {
        binding.contentHero.rvHero?.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.contentHero.rvHero?.setHasFixedSize(true)
        adapter = HeroAdapter()
        binding.contentHero.rvHero?.adapter = adapter
    }

    private fun initViewModel() {
        heroListViewModel = ViewModelProviders.of(this).get(HeroListViewModel::class.java)
        quoteViewModel = ViewModelProviders.of(this).get(QuoteViewModel::class.java)
    }

    fun refreshQuote() {
        quoteViewModel.getRandomQuote()
    }

    private fun getHeroList() {
        heroListViewModel.getHeroList()
    }
}
