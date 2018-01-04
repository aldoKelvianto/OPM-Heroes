package com.aldoapps.opmsclass

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.view.View
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
        heroViewModel?.isLoading?.observe(this, Observer {
            it?.let { isLoading ->
                if (isLoading) {
                    binding?.contentMain?.progressBar?.visibility = View.VISIBLE
                } else {
                    binding?.contentMain?.progressBar?.visibility = View.GONE
                }
            }
        })

        heroViewModel?.name?.observe(this, Observer {
            it?.let { name ->
                binding?.contentMain?.tvName?.text = name
            }
        })

        heroViewModel?.photo?.observe(this, Observer {
            it?.let { imageRes ->
                binding?.contentMain?.ivPhoto?.setImageResource(imageRes)
            }
        })

        heroViewModel?.rank?.observe(this, Observer {
            it?.let { rank ->
                binding?.contentMain?.tvRank?.text = rank.toString()
            }
        })
    }

    private fun fetchHeroData() {
        heroViewModel?.fetchDataForMePlease()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}
