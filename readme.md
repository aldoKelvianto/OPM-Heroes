I managed to combine JUnit 5, Robolectric, PowerMock, AssertJ, and Kotlin with some caveat.

If I'm using a `PowerMockRunner` on a test, I can't use JUnit 5 Parameterized test. The compiler throw `org.powermock.api.mockito.ClassNotPreparedException` Exception and will tell you that you haven't prepare the Class under test. So the following test wouldn't work.

```kotlin
@RunWith(PowerMockRunner::class)
@PrepareForTest(SystemClock::class)
class HeroDatabaseTest {

    @ParameterizedTest
    @CsvSource(
            "Tatsumaki, Tornado of Terror",
            "Bang, Silver Fang",
            "King, Strongest Man",
            "Saitama, Caped Baldy"
    )
    fun getHeroAlias(heroName: String, alias: String) {
        PowerMockito.mockStatic(SystemClock::class.java)
        val hero = HeroDatabase.getHero(heroName)
        assertThat(hero?.alias).isEqualTo(alias)
    }
}
```

But this test would work.

```kotlin
@RunWith(PowerMockRunner::class)
@PrepareForTest(SystemClock::class)
class HeroDatabaseTest {

    @Test
    fun getHeroAlias() {
        val heroName = "Tatsumaki"
        val alias = "Tornado of Terror"
        PowerMockito.mockStatic(SystemClock::class.java)

        val hero = HeroDatabase.getHero(heroName)

        assertThat(hero?.alias).isEqualTo(alias)
    }
}

```

And this test would work too.

```kotlin
class QuoteDatabaseTest {

    @ParameterizedTest
    @CsvSource(
            "Tatsumaki, 1",
            "King, 2",
            "Saitama, 11"
    )
    fun testQuoteSize(author: String, expected: Int) {
        val quote = QuoteDatabase.getQuotesByAuthor(author)
        assertEquals(expected, quote.size)
    }
}
```

My guess is since PowerMock or Mockito is using JUnit 4, not 5. Its unable to process a `ParameterizedTest` annotation. Maybe it will be fixed in the future.

Another thing I notice is some test doesn't increase Code Coverage. I'm still investigating this issue.