package com.aldoapps.opmsclass.hero.view

import android.support.v7.widget.RecyclerView
import com.aldoapps.opmsclass.databinding.ItemHeroBinding

/**
 * Created by aldo on 01/02/18.
 */
class HeroViewHolder(private val binding: ItemHeroBinding) : RecyclerView.ViewHolder(binding.root) {

    fun setHero(hero: HeroModel) {
        binding.hero = hero
    }
}
