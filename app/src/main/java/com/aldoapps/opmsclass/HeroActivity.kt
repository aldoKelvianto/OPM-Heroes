package com.aldoapps.opmsclass

import android.arch.lifecycle.Observer
import android.arch.lifecycle.Transformations
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.aldoapps.opmsclass.databinding.ActivityMainBinding
import com.aldoapps.opmsclass.hero.util.HeroModelMapper
import com.aldoapps.opmsclass.hero.view.HeroAdapter
import com.aldoapps.opmsclass.hero.view.HeroListViewModel
import com.aldoapps.opmsclass.quote.QuoteViewModel
import com.aldoapps.opmsclass.quote.util.QuoteModelMapper
import kotlinx.android.synthetic.main.content_main.*

class HeroActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var heroListViewModel: HeroListViewModel

    private lateinit var quoteViewModel: QuoteViewModel

    private lateinit var adapter: HeroAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.setLifecycleOwner(this)

        initRecyclerView()
        initViewModel()
        refreshQuote(null)
        fetchHeroData()
    }

    private fun initRecyclerView() {
        rv_hero.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        rv_hero.setHasFixedSize(true)
        adapter = HeroAdapter()
        rv_hero.adapter = adapter
    }

    private fun initViewModel() {
        heroListViewModel = ViewModelProviders.of(this).get(HeroListViewModel::class.java)
        binding.contentMain?.heroListViewModel = heroListViewModel

        heroListViewModel.heroListLiveData.observe(this, Observer {
            it?.let {
                adapter.addHeroList(it)
            }
        })

        quoteViewModel = ViewModelProviders.of(this).get(QuoteViewModel::class.java)
        binding.contentMain?.quoteViewModel = quoteViewModel

        val quoteEntityLiveData = quoteViewModel.quoteEntityLiveData
        Transformations.map(quoteEntityLiveData, {
            QuoteModelMapper.transformQuoteEntity(it)
        }).observe(this, Observer {
            it ?: return@Observer
            quoteViewModel.author.set(it.author)
            quoteViewModel.quote.set(it.quote)
        })
    }

    fun refreshQuote(view: View?) {
        quoteViewModel.getRandomQuote()
    }

    fun fetchHeroData() {
        heroListViewModel.queryHeroList()
    }
}
