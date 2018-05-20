package com.aldoapps.opmsclass.herolist.repository

import android.os.SystemClock
import com.aldoapps.opmsclass.hero.repository.HeroDatabase
import org.assertj.core.api.Assertions.assertThat
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnit

/**
 * Created by aldo on 01/02/18.
 */
class HeroDatabaseTest {

    @get:Rule
    val mockitoRule = MockitoJUnit.rule()

    @Before
    fun setup() {
    }

    @Test
    fun shouldReturnHeroList_whenGetHeroListFromHeroDatabase() {
        // Given
        // When
        val heroList = HeroDatabase.getHeroList()
        // Then
        assertThat(heroList).hasSize(13)
    }

    @Test
    fun shouldReturnDefaultHero_whenGetDefaultHeroFromHeroDatabase() {
        // Given
        // When
        val defaultHero = HeroDatabase.getDefaultHero()

        assertThat(defaultHero.name).isEqualToIgnoringCase("saitama")
        assertThat(defaultHero.alias).isEqualToIgnoringCase("caped baldy")
        assertThat(defaultHero.rank).isEqualTo(0)
    }

    @ParameterizedTest
    @CsvSource(
            "Tatsumaki, Tornado of Terror",
            "Saitama, Caped Baldy"
    )
    fun nameAndAliasShouldMatch_whenGetHeroAliasFromHeroDatabase(name: String, alias: String) {
        Mockito.mock(SystemClock::class.java)

        // When
        val hero = HeroDatabase.getHero(name)

        // Then
        assertThat(hero?.alias).isEqualTo(alias)
    }

}