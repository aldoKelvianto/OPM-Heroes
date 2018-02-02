package com.aldoapps.opmsclass.quote

/**
 * Created by aldo on 05/01/18.
 */
object QuoteDatabase {

    private val quoteList: List<Quote> by lazy {
        listOf(
                Quote("Saitama", "100 push-ups, 100 sit-ups, 100 squats, and a 10km run EVERY SINGLE DAY!!!"),
                Quote("Saitama", "OK"),
                Quote("Saitama", "Overwhelming strength is boring"),
                Quote("Saitama", "If the heroes run and hide, who will stay and fight?"),
                Quote("Saitama", "I'm not a heroEntity because I want your approval. I do it because I want to!"),
                Quote("Saitama", "I'm just a guy who's a heroEntity for fun"),
                Quote("Saitama", "I'll leave tomorrow's problems to tomorrow's me"),
                Quote("Saitama", "Human beings are strong because we have the ability to change ourselves."),
                Quote("Saitama", "If you really want to be strong... Stop caring about what your surrounding thinks of you!"),
                Quote("Saitama", """Do you honestly think that you won't get any stronger for the rest of your life?
                    Instead of sitting around frustrated, it's better to keep on moving forward.
                """),
                Quote("Saitama", """"Heroes and the police don't do their jobs because someone says "please". Right?"""),
                Quote("Atomic Samurai", "I only accept the strong."),
                Quote("Atomic Samurai", "I'm not middle-aged. I'm 37"),
                Quote("Bang", "You do not need to know who the victor is within a battle using martial arts. That is the beauty of this art"),
                Quote("Bang", "You're too young to worry about failure"),
                Quote("Child Emperor", "I've got cram school, so can I go?"),
                Quote("Sweet Mask", "A heroEntity must be tough, strong and beautiful... As well as able to promptly and splendidly eradicate evil."),
                Quote("Genos", "Incinerate!"),
                Quote("Genos", "I leat my guard down again. I never learn..."),
                Quote("Genos", "Instead of self defense, I seek absolute destructive strength"),
                Quote("Genos", "I simply cannot imagine... ever approaching Master's strength"),
                Quote("King", "Romance games are my oasis."),
                Quote("King", "I'm a 29 years old, unemployed, anti-social otaku loser!"),
                Quote("Metal Bat", "I left my little sister's piano recital for this. If this isn't important, I'm trashing this place!"),
                Quote("Metal Knight", "Strong weapons are necessary... for peace!"),
                Quote("Puri Puri Prisoner", "I sense something stimulating!"),
                Quote("Tank Top Master", "The tank-top is strength itself!"),
                Quote("Tatsumaki", "How dare you call me brat! I'm older than you!"),
                Quote("Watchdog Man", "Nothing Unusual"),
                Quote("Watchdog Man", "Someone farted..")
        )
    }

    fun getQuotes(): List<Quote> = quoteList

    fun getQuotesByAuthor(author: String): List<Quote> =
            quoteList.filter {
                it.author.equals(author, true)
            }

}