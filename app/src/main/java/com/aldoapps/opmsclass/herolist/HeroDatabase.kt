package com.aldoapps.opmsclass.herolist

import android.os.SystemClock
import com.aldoapps.opmsclass.R
import java.util.*

/**
 * Created by aldo on 04/01/18.
 */
object HeroDatabase {

    private var heroMap: HashMap<String, Hero> = HashMap()

    init {
        heroMap.put("Blast", Hero("Blast", "Blast", R.mipmap.ic_launcher_round, 1, "Strongest"))
        heroMap.put("Tatsumaki", Hero("Tatsumaki", "Tornado of Terror", R.mipmap.ic_launcher_round, 2, "Esper"))
        heroMap.put("Bang", Hero("Bang", "Silver Fang", R.mipmap.ic_launcher_round, 3, "Matrial Artist"))
        heroMap.put("King", Hero("King", "Strongest Man", R.mipmap.ic_launcher_round, 7, "Gamer"))
    }

    // Long operation
    public fun getHero(name: String): Hero? {
        SystemClock.sleep(getDuration())
        return heroMap.get(name)
    }

    private fun getDuration() = Random().nextInt(5_000).toLong()

    public fun getDefaultHero() = Hero("Saitama", "Caped Baldy", R.mipmap.ic_launcher_round, 0, "One Punch Man")
}