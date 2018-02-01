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
public class HeroDatabaseTest {
//
//    @BeforeAll
//    fun setUp() {
//
//    }

    @Test
    fun getHeroList() {
        // Given
        val heroList = HeroDatabase.getHeroList()
        // When
        val size = heroList.size
        // Then
        assertThat(size).isEqualTo(5)
    }

    //    @ParameterizedTest
//    @CsvSource(
//            "Tatsumaki, Tornado of Terror",
//            "Bang, Silver Fang",
//            "King, Strongest Man",
//            "Saitama, Caped Baldy"
//    )
//    fun getHeroAlias(heroName: String, alias: String) {
    fun getHeroAlias(heroName: String, alias: String) {
        val heroName = "Tatsumaki"
        val alias = "Tornado of Terror"
        PowerMockito.mockStatic(SystemClock::class.java)
//        PowerMockito.`when`(SystemClock.currentThreadTimeMillis()).thenReturn(1L);

        // When
        val hero = HeroDatabase.getHero(heroName)

        // Then
        assertThat(hero?.alias).isEqualTo(alias)
    }

}