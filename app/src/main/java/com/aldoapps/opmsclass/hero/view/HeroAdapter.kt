package com.aldoapps.opmsclass.hero.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.aldoapps.opmsclass.databinding.ItemHeroBinding

/**
 * Created by aldo on 01/02/18.
 */
class HeroAdapter : RecyclerView.Adapter<HeroViewHolder>() {

    private val heroList = ArrayList<HeroModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeroViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemHeroBinding.inflate(inflater, parent, false)
        return HeroViewHolder(binding)
    }

    override fun getItemCount(): Int = heroList.size

    override fun onBindViewHolder(holder: HeroViewHolder, position: Int) {
        val hero = heroList[position]
        holder.setHero(hero)
    }

    fun addHeroList(heroList: List<HeroModel>) {
        this.heroList.addAll(heroList)
        notifyDataSetChanged()
    }

    fun add(hero: HeroModel) {
        heroList.add(hero)
        notifyItemInserted(heroList.size)
    }
}