package com.aldoapps.opmsclass.herolist.interactor

import android.os.Build
import com.aldoapps.opmsclass.hero.interactor.GetHeroList
import com.aldoapps.opmsclass.hero.repository.HeroDatabase
import org.assertj.core.api.Assertions.assertThat
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnit
import org.mockito.junit.MockitoRule
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

/**
 * Created by aldo on 02/02/18.
 */
@RunWith(RobolectricTestRunner::class)
@Config(sdk = [Build.VERSION_CODES.N_MR1])
class GetHeroListTest {

  private lateinit var heroDatabase: HeroDatabase

  @get:Rule
  val mockitoRule: MockitoRule = MockitoJUnit.rule()

  @Before
  fun setup() {
    heroDatabase = HeroDatabase
  }

  @Test
  fun shouldReturnList_whenGetHeroFromDb() {
    GetHeroList(heroDatabase) {
      assertThat(it).isInstanceOf(List::class.java)
      assertThat(it).hasSize(13)
    }.execute()
  }
}