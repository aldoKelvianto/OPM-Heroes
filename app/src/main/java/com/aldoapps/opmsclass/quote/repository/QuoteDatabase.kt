package com.aldoapps.opmsclass.quote.repository

import com.aldoapps.opmsclass.hero.repository.HeroDatabase
import com.aldoapps.opmsclass.hero.repository.HeroEntity

/**
 * Created by aldo on 05/01/18.
 */
object QuoteDatabase {

    private val HERO_ENTITY_LIST: List<HeroEntity> by lazy {
        HeroDatabase.getHeroList()
    }

    private val QUOTE_ENTITY_LIST: List<QuoteEntity> by lazy {
        val saitama = getHeroByName("Saitama")
        val kamikaze = getHeroByName("Kamikaze")
        val bang = getHeroByName("Bang")
        val sweetMask = getHeroByName("Sweet Mask")
        val genos = getHeroByName("Genos")
        val king = getHeroByName("King")
        val bad = getHeroByName("Bad")
        val bofoi = getHeroByName("Bofoi")
        val purisoner = getHeroByName("Puri-puri Prisoner")
        val tanktop = getHeroByName("Tanktop Master")
        val tatsumaki = getHeroByName("Tatsumaki")
        val watchdog = getHeroByName("Watchdog Man")

        listOf(
                QuoteEntity(saitama,
                        "100 push-ups, 100 sit-ups, 100 squats, and a 10km run EVERY SINGLE DAY!!!"),
                QuoteEntity(saitama, "OK"),
                QuoteEntity(saitama, "Overwhelming strength is boring"),
                QuoteEntity(saitama, "If the heroes run and hide, who will stay and fight?"),
                QuoteEntity(saitama, "I'm not a heroListEntity because I want your approval. I do it because I want to!"),
                QuoteEntity(saitama, "I'm just a guy who's a heroListEntity for fun"),
                QuoteEntity(saitama, "I'll leave tomorrow's problems to tomorrow's me"),
                QuoteEntity(saitama, "Human beings are strong because we have the ability to change ourselves."),
                QuoteEntity(saitama, "If you really want to be strong... Stop caring about what your surrounding thinks of you!"),
                QuoteEntity(saitama, """Do you honestly think that you won't get any stronger for the rest of your life?
                    Instead of sitting around frustrated, it's better to keep on moving forward.
                """),
                QuoteEntity(saitama, """"Heroes and the police don't do their jobs because someone says "please". Right?"""),
                QuoteEntity(kamikaze, "I only accept the strong."),
                QuoteEntity(kamikaze, "I'm not middle-aged. I'm 37"),
                QuoteEntity(bang, "You do not need to know who the victor is within a battle using martial arts. That is the beauty of this art"),
                QuoteEntity(bang, "You're too young to worry about failure"),
                QuoteEntity(bang, "I've got cram school, so can I go?"),
                QuoteEntity(sweetMask, "A hero must be tough, strong and beautiful... As well as able to promptly and splendidly eradicate evil."),
                QuoteEntity(sweetMask, "I ain't that sweet."),
                QuoteEntity(genos, "Incinerate!"),
                QuoteEntity(genos, "I leat my guard down again. I never learn..."),
                QuoteEntity(genos, "Instead of self defense, I seek absolute destructive strength"),
                QuoteEntity(genos, "I simply cannot imagine... ever approaching Master's strength"),
                QuoteEntity(king, "Romance games are my oasis."),
                QuoteEntity(king, "I'm a 29 years old, unemployed, anti-social otaku loser!"),
                QuoteEntity(bad, "I left my little sister's piano recital for this. If this isn't important, I'm trashing this place!"),
                QuoteEntity(bad, "Fuck reasons. It's fightin spirit!"),
                QuoteEntity(bofoi, "Strong weapons are necessary... for peace!"),
                QuoteEntity(purisoner, "I sense something stimulating!"),
                QuoteEntity(tanktop, "The tank-top is strength itself!"),
                QuoteEntity(tanktop, "Be careful, you're not even wearing a tanktop"),
                QuoteEntity(tatsumaki, "How dare you call me brat! I'm older than you!"),
                QuoteEntity(watchdog, "Nothing Unusual"),
                QuoteEntity(watchdog, "Someone farted..")
        )
    }

    fun getQuotes(): List<QuoteEntity> = QUOTE_ENTITY_LIST

    fun getQuotesByAuthor(author: String): List<QuoteEntity> =
            QUOTE_ENTITY_LIST.filter {
                it.hero.name.equals(author, true)
            }

    private fun getHeroByName(name: String) =
            HERO_ENTITY_LIST.first {
                it.name.equals(name, true)
            }
}