package com.aldoapps.opmsclass.hero.repository

import android.os.SystemClock
import com.aldoapps.opmsclass.R
import java.util.*
import kotlin.collections.HashMap

/**
 * Created by aldo on 04/01/18.
 */
object HeroDatabase {

    private var HERO_ENTITY_LIST: HashMap<String, HeroEntity> = HashMap()

    init {
        HERO_ENTITY_LIST["Blast"] = HeroEntity("Blast", "Blast", R.mipmap.ic_launcher_round, 1, "Probably Saitama's Dad")
        HERO_ENTITY_LIST["Tatsumaki"] = HeroEntity("Tatsumaki", "Tornado of Terror", R.mipmap.ic_launcher_round, 2, "Tsundere Loli trope")
        HERO_ENTITY_LIST["Bang"] = HeroEntity("Bang", "Silver Fang", R.mipmap.ic_launcher_round, 3, "Netero with hair")
        HERO_ENTITY_LIST["King"] = HeroEntity("King", "Strongest Man", R.mipmap.ic_launcher_round, 7, "Best Gundam pilot")
        HERO_ENTITY_LIST["Saitama"] = HeroEntity("Saitama", "Caped Baldy", R.mipmap.ic_launcher_round, 0, "One Punch Man")
        HERO_ENTITY_LIST["Kamikaze"] = HeroEntity("Kamikaze", "Atomic Samurai", R.mipmap.ic_launcher_round, 0, "World war II reference")
        HERO_ENTITY_LIST["Sweet Mask"] = HeroEntity("Sweet Mask", "Sweet Mask", R.mipmap.ic_launcher_round, 0, "Ikemen trope")
        HERO_ENTITY_LIST["Genos"] = HeroEntity("Genos", "Demon Cyborg", R.mipmap.ic_launcher_round, 0, "History's strongest disciple")
        HERO_ENTITY_LIST["Bad"] = HeroEntity("Bad", "Metal Bat", R.mipmap.ic_launcher_round, 0, "If Hulk is a Japanese")
        HERO_ENTITY_LIST["Bofoi"] = HeroEntity("Bofoi", "Metal Knight", R.mipmap.ic_launcher_round, 0, "Eggman")
        HERO_ENTITY_LIST["Watchdog Man"] = HeroEntity("Watchdog Man", "Watchdog Man", R.mipmap.ic_launcher_round, 0, "Eggman")
        HERO_ENTITY_LIST["Tanktop Master"] = HeroEntity("Tanktop Master", "Tanktop Master", R.mipmap.ic_launcher_round, 0, "TTM")
        HERO_ENTITY_LIST["Puri-puri Prisoner"] = HeroEntity("Puri-puri Prisoner", "Puri-puri Prisoner", R.mipmap.ic_launcher_round, 0, "Eggman")

    }

    // Long operation
    fun getHero(name: String): HeroEntity? {
        // Emulate network call
        SystemClock.sleep(getDuration())
        return HERO_ENTITY_LIST.get(name)
    }

    private fun getDuration() = Random().nextInt(3_500).toLong()

    fun getDefaultHero() = HeroEntity("Saitama", "Caped Baldy", R.mipmap.ic_launcher_round, 0, "One Punch Man")

    fun getHeroList(): List<HeroEntity> = HERO_ENTITY_LIST
            .map {
                it.value
            }
            .toList()

}