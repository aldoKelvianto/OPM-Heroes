package com.aldoapps.opmsclass.herolist.repository

import android.os.SystemClock
import com.aldoapps.opmsclass.R
import java.util.*
import kotlin.collections.HashMap

/**
 * Created by aldo on 04/01/18.
 */
object HeroDatabase {

    private var heroMap: HashMap<String, HeroEntity> = HashMap()

    init {
        heroMap.put("Blast", HeroEntity("Blast", "Blast", R.mipmap.ic_launcher_round, 1, "Strongest"))
        heroMap.put("Tatsumaki", HeroEntity("Tatsumaki", "Tornado of Terror", R.mipmap.ic_launcher_round, 2, "Esper"))
        heroMap.put("Bang", HeroEntity("Bang", "Silver Fang", R.mipmap.ic_launcher_round, 3, "Matrial Artist"))
        heroMap.put("King", HeroEntity("King", "Strongest Man", R.mipmap.ic_launcher_round, 7, "Gamer"))
        heroMap.put("Saitama", HeroEntity("Saitama", "Caped Baldy", R.mipmap.ic_launcher_round, 0, "One Punch Man"))
    }

    // Long operation
    fun getHero(name: String): HeroEntity? {
        // Emulate network call
        SystemClock.sleep(getDuration())
        return heroMap.get(name)
    }

    private fun getDuration() = Random().nextInt(3_500).toLong()

    fun getDefaultHero() = HeroEntity("Saitama", "Caped Baldy", R.mipmap.ic_launcher_round, 0, "One Punch Man")

    fun getHeroList(): List<HeroEntity> = heroMap
            .map {
                it.value
            }
            .toList()

}