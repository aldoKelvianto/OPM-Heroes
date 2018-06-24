package com.aldoapps.opmsclass.hero.repository

import android.os.SystemClock
import com.aldoapps.opmsclass.R
import com.aldoapps.opmsclass.util.RandomUtil

/**
 * Created by aldo on 04/01/18.
 */
object HeroDatabase {

    private var HERO_ENTITY_LIST: HashMap<String, HeroEntity> = HashMap()

    init {
        HERO_ENTITY_LIST["Saitama"] = HeroEntity("Saitama", "Caped Baldy", R.drawable.ic_saitama, 0, "One Punch Man")
        HERO_ENTITY_LIST["Blast"] = HeroEntity("Blast", "Blast", R.drawable.ic_blast, 1, "Probably Saitama's Dad")
        HERO_ENTITY_LIST["Tatsumaki"] = HeroEntity("Tatsumaki", "Tornado of Terror", R.drawable.ic_tatsumaki, 2, "Tsundere Loli trope")
        HERO_ENTITY_LIST["Bang"] = HeroEntity("Bang", "Silver Fang", R.drawable.ic_bang, 3, "Netero with hair")
        HERO_ENTITY_LIST["Kamikaze"] = HeroEntity("Kamikaze", "Atomic Samurai", R.drawable.ic_kamikaze, 4, "World war II reference")
        HERO_ENTITY_LIST["Bofoi"] = HeroEntity("Bofoi", "Metal Knight", R.drawable.ic_bofoi, 6, "Eggman")
        HERO_ENTITY_LIST["King"] = HeroEntity("King", "Strongest Man", R.drawable.ic_king, 7, "Best Gundam pilot")
        HERO_ENTITY_LIST["Watchdog Man"] = HeroEntity("Watchdog Man", "Watchdog Man", R.drawable.ic_watchdog_man, 12, "Half Dog Half Man")
        HERO_ENTITY_LIST["Genos"] = HeroEntity("Genos", "Demon Cyborg", R.drawable.ic_genos, 14, "History's strongest disciple")
        HERO_ENTITY_LIST["Tanktop Master"] = HeroEntity("Tanktop Master", "Tanktop Master", R.drawable.ic_tanktop_master, 15, "Cult lead")
        HERO_ENTITY_LIST["Bad"] = HeroEntity("Bad", "Metal Bat", R.drawable.ic_bad, 16, "If Hulk is a Japanese")
        HERO_ENTITY_LIST["Puri-puri Prisoner"] = HeroEntity("Puri-puri Prisoner", "Puri-puri Prisoner", R.drawable.ic_puripuri_purisoner, 17, "Serial Rapist")
        HERO_ENTITY_LIST["Sweet Mask"] = HeroEntity("Sweet Mask", "Sweet Mask", R.drawable.ic_sweet_mask, 18, "Ikemen trope")
    }

    // Long operation
    fun getHero(name: String): HeroEntity? {
        // Emulate network call
        SystemClock.sleep(RandomUtil.getRandomDuration())
        return HERO_ENTITY_LIST.get(name)
    }

    fun getDefaultHero() = HeroEntity("Saitama", "Caped Baldy", R.mipmap.ic_launcher_round, 0, "One Punch Man")

    fun getHeroList(): List<HeroEntity> {
        return HERO_ENTITY_LIST
                .map {
                    it.value
                }
                .toList()
                .sortedBy {
                    it.rank
                }
    }

}