package com.sevenpeakssoftware.kyawsoewin

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.sevenpeakssoftware.kyawsoewin.cache.CarDatabase
import com.sevenpeakssoftware.kyawsoewin.cache.dao.CarDao
import com.sevenpeakssoftware.kyawsoewin.cache.entity.CacheCar
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import kotlinx.coroutines.test.runTest
import org.junit.*
import javax.inject.Inject

@HiltAndroidTest
class CarDaoTest {

    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    val hiltAndroidRule = HiltAndroidRule(this)

    @Inject
    lateinit var carDatabase: CarDatabase
    private lateinit var carDao: CarDao

    @Before
    fun setUp() {
        hiltAndroidRule.inject()
        carDao = carDatabase.getCarDao()
    }

    @Test
    fun insertCar_returnsSingleCar() = runTest {
        val car = CacheCar(
            id = 1,
            dateTime = "",
            title = "Title",
            ingress = "",
            image = "https://images.unsplash.com/photo-1597429926308-ffc8cd6f55fd?crop=entropy&cs=tinysrgb&fit=crop&fm=jpg&h=100&ixid=MnwxfDB8MXxyYW5kb218MHx8fHx8fHx8MTY5MDQyNTc3OA&ixlib=rb-4.0.3&q=80&utm_campaign=api-credit&utm_medium=referral&utm_source=unsplash_source&w=100"
        )
        carDao.insertTicketList(mutableListOf(car))
        val result = carDao.getTicketList()
        Assert.assertEquals(1, result.size)
    }


    @After
    fun closeDatabase() {
        carDatabase.close()
    }
}