package com.aldoapps.opmsclass.herolist.interactor

import com.aldoapps.opmsclass.herolist.repository.HeroDatabase
import com.aldoapps.opmsclass.herolist.repository.HeroEntity
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner

/**
 * Created by aldo on 02/02/18.
 */
@RunWith(RobolectricTestRunner::class)
class GetHeroListTest {

    @Test
    fun testGetHero() {
        GetHeroList(HeroDatabase, object : Callback<List<HeroEntity>> {
            override fun onFinished(heroList: List<HeroEntity>) {
                assertThat(heroList.size).isEqualTo(5)
            }
        })
    }
}