package com.aldoapps.opmsclass.herolist.interactor

import android.os.SystemClock
import com.aldoapps.opmsclass.herolist.repository.HeroDatabase
import com.aldoapps.opmsclass.herolist.repository.HeroEntity
import org.assertj.core.api.Assertions.anyOf
import org.assertj.core.api.Assertions.assertThat
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.ArgumentMatchers.any
import org.mockito.ArgumentMatchers.anyList
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnit
import org.mockito.junit.MockitoRule
import org.robolectric.RobolectricTestRunner

/**
 * Created by aldo on 02/02/18.
 */
@RunWith(RobolectricTestRunner::class)
class GetHeroListTest {

    private lateinit var heroDatabase: HeroDatabase

    @get:Rule
    val mockitoRule: MockitoRule = MockitoJUnit.rule()

    @Mock
    private lateinit var mockCallback: Callback<List<HeroEntity>>

    @Before
    fun setup() {
        heroDatabase = HeroDatabase
    }

    @Test
    fun getHeroFromDb_shouldReturnList() {
        GetHeroList(heroDatabase, object : Callback<List<HeroEntity>> {
            override fun onFinished(heroList: List<HeroEntity>) {
                assertThat(heroList).isInstanceOf(List::class.java)
                assertThat(heroList).hasSize(5)
            }
        }).execute()
    }

    @Test
    fun getHeroFromDb_shouldTriggerCallback() {
        // Given
        // When
        GetHeroList(heroDatabase, mockCallback).execute()

        val timeOutDuration = 3_500L
        Thread.sleep(timeOutDuration)

        // Then
        Mockito.verify(mockCallback).onFinished(anyList())
        Mockito.verifyNoMoreInteractions(mockCallback)
    }

}