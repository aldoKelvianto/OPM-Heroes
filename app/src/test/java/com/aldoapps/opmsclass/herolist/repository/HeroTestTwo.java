package com.aldoapps.opmsclass.herolist.repository;

import android.os.SystemClock;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

/**
 * Created by aldo on 01/02/18.
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(SystemClock.class)
public class HeroTestTwo {

    @Before
    public void setup() {
        PowerMockito.mockStatic(SystemClock.class);
    }

    //    @ParameterizedTest
//    @CsvSource({
//            "Tatsumaki, Tornado of Terror",
//            "Bang, Silver Fang",
//            "King, Strongest Man",
//            "Saitama, Caped Baldy"})
//    public void getHeroAlias(String heroName, String alias) throws Exception {
    @Test
    public void getHeroAlias() throws Exception {
        String heroName = "Saitama";
        String alias = "Caped Baldy";
//        PowerMockito.mockStatic(SystemClock.class);
//        PowerMockito.when(SystemClock.currentThreadTimeMillis()).thenReturn(1L);

        // When
        HeroEntity hero = HeroDatabase.INSTANCE.getHero(heroName);

        // Then
        assertThat(hero.getAlias()).isEqualTo(alias);
    }

}
