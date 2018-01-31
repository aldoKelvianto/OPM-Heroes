package com.aldoapps.opmsclass.herolist

import android.os.SystemClock
import com.aldoapps.opmsclass.R
import java.util.*

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
    }

    // Long operation
    public fun getHero(name: String): HeroEntity? {
        SystemClock.sleep(getDuration())
        return heroMap.get(name)
    }

    private fun getDuration() = Random().nextInt(5_000).toLong()

    public fun getDefaultHero() = HeroEntity("Saitama", "Caped Baldy", R.mipmap.ic_launcher_round, 0, "One Punch Man")
}