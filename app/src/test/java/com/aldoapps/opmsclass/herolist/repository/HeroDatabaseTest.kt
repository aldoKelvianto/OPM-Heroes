package com.aldoapps.opmsclass.herolist.repository

import android.os.SystemClock
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.powermock.api.mockito.PowerMockito
import org.powermock.core.classloader.annotations.PrepareForTest
import org.powermock.modules.junit4.PowerMockRunner

/**
 * Created by aldo on 01/02/18.
 */
@RunWith(PowerMockRunner::class)
@PrepareForTest(SystemClock::class)
class HeroDatabaseTest {

    @Test
    fun getHeroList() {
        // Given
        // When
        val heroList = HeroDatabase.getHeroList()
        // Then
        assertThat(heroList).hasSize(5)
    }

    @Test
    fun getDefaultHero() {
        // Given
        // When
        val defaultHero = HeroDatabase.getDefaultHero()

        assertThat(defaultHero.name).isEqualToIgnoringCase("saitama")
        assertThat(defaultHero.alias).isEqualToIgnoringCase("caped baldy")
        assertThat(defaultHero.rank).isEqualTo(0)
    }

    @Test
    fun getHeroAlias() {
        val heroName = "Tatsumaki"
        val alias = "Tornado of Terror"
        PowerMockito.mockStatic(SystemClock::class.java)

        // When
        val hero = HeroDatabase.getHero(heroName)

        // Then
        assertThat(hero?.alias).isEqualTo(alias)
    }

}